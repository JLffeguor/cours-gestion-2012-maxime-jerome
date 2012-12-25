package be.winecave.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import be.winecave.main.WineCave;

//TODO update class to use in local software --maxime 11/12/12 
public abstract class FileUtil {
	private static Log log = LogFactory.getLog(FileUtil.class);
	/**
	 * in case of a jar this the jar location 
	 * in case of eclipse this is the bin folder location
	 */
	private static Path APP_LOCATION;
	private static Path INSTALLATION_FOLDER;
	
	private static final String JAR_NAME = "winecave.jar";
	private static final Charset DEFAULT_FILE_ENCODING = Charset.forName("UTF-8");
	
	private static final String CONFIG_DIR_NAME = "Config";
	private static final String POSTINSTALLATION_DIR_NAME = "PostInstallationData";
	
	public static void initialize() {
		try {
			//this is the only way i found to get the jar filesystem location with avoid special character problems --maxime 13/12/12
			//TODO test on windows and macOSX systems
			APP_LOCATION = Paths.get(WineCave.class.getProtectionDomain().getCodeSource().getLocation().toURI());
			
			if (APP_LOCATION.toString().endsWith(JAR_NAME)) { //if the app executing from a jar
				INSTALLATION_FOLDER = APP_LOCATION.getParent();
			} else { //otherwise in eclipse i.e. this is the bin folder
				INSTALLATION_FOLDER = APP_LOCATION;
			}
			
			System.out.println("jar location" + APP_LOCATION);
			System.out.println("jar parent folder location" + INSTALLATION_FOLDER);
			log.debug("JAR_PARENTFOLDER_LOCATION initalized with : "+ INSTALLATION_FOLDER);
		} catch (URISyntaxException e) {
			throw new RuntimeException(FileUtil.class + "can't initialize the JAR_LOCATION_FOLDER field",e);
		}
	}
	
	
	public static Path getInstallationFolder() {
		if(INSTALLATION_FOLDER == null) {
			initialize();
		}
		return INSTALLATION_FOLDER;
	}
	
	public static Path getJarLocation() {
		if(APP_LOCATION == null) {
			initialize();
		}
		return APP_LOCATION;
	}

	public static Charset getDefaultFileEncoding() {
		return DEFAULT_FILE_ENCODING;
	}
	
	public static String getFileSystemSeparator() {
		return FileSystems.getDefault().getSeparator();
	}
	
	/**
	 * installation folder is the folder where the jar is installed or bin in eclipse  
	 */
	public static Path getPathIntoInstallationFolder(String fileName) {
		return getInstallationFolder().resolve(fileName);
	}
	
	public static Path getPathIntoPostInstallationFolder(String fileName) {
		return getInstallationFolder().resolve(POSTINSTALLATION_DIR_NAME + FileUtil.getFileSystemSeparator() + fileName);
	}
	
	public static Path getPathIntoConfigFolder(String fileName) {
		return getInstallationFolder().resolve(CONFIG_DIR_NAME + getFileSystemSeparator() + fileName);
	}
    

//TODO uncomment when found Spring mvc MultipartFile remplacement for loca sofwtare use --maxime 13/12/12
//
//    /** If an uploaded MultipartFile has the name "toto.jpeg", and we give "123" as newNamePrefixFileName, this method will return "123.jpg".
//     * @throws InvalidImageFileException 
//     */
//    public static String assembleImageFileNameWithCorrectExtention(MultipartFile multipartFile, String newPrefixFileName) throws InvalidImageFileException {
//        String type = multipartFile.getContentType();
//        
//        if (!type.contains("image")) {
//            if(log.isDebugEnabled()){
//                log.debug("someone try to upload this fille but this isn't an image : "+multipartFile.getOriginalFilename());}
//            throw new InvalidImageFileException("File is not an image.  Detected type = '"+type+"'");
//        }
//        
//        ////// Get the right extension
//        String extension;
//        switch (type) {
//        case "image/gif":
//            extension = "gif";
//            break;
//        case "image/jpeg" :
//        case "image/pjpeg" ://internet explorer IFuckDevWhenTheyWantToMakeItSimple special MimeType for jpeg
//            extension = "jpg";
//            break;
//        case "image/png" : 
//        case "image/x-png"://internet explorer IFuckDevWhenTheyWantToMakeItSimple special MimeType for png
//            extension = "png";
//            break;
//        case "image/svg+xml" :
//            extension = "svg";
//            break;
//        default:
//            throw new InvalidImageFileException("bad image type : png , svg , jpeg and gif are only accepted. Detected type = '"+type+"'");
//        }
//        
//        // Compute the new file name
//        return newPrefixFileName + "." + extension;
//    }


//TODO uncomment when found Spring mvc MultipartFile remplacement for loca sofwtare use --maxime 13/12/12
//
//    /**
//     * write the picture in the right folder    
//     * @param path
//     * @param multipartFile
//     * @return
//     * @throws InvalidImageFileException 
//     * @throws IOException 
//     * @throws Exception 
//     */
//    public static File uploadFile(MultipartFile multipartFile, String path, String fileName) throws InvalidImageFileException, IOException {
//        if (multipartFile.getSize()>1500000)  {
//            throw new InvalidImageFileException("file is too large 1.5Mo maximum");
//        }
//        if (path == null) {
//            throw new IllegalArgumentException("File path(image) can't be null");
//        }
//        
//        if (fileName == null) {
//            throw new IllegalArgumentException("File name(image) can't be null");
//        }
//        File folder = FileUtil.ensureFolderExists(path);
//        if(log.isDebugEnabled()){
//            log.debug("genFolder : "+folder.getAbsolutePath());
//            log.debug("file type is :"+multipartFile.getContentType());
//            log.debug("file original name is "+multipartFile.getOriginalFilename());
//        }
//        
//        
//        if (multipartFile.isEmpty()){
//            if(log.isDebugEnabled()){
//                log.debug("someone try to submit an empty file : "+multipartFile.getOriginalFilename());}
//            throw new InvalidImageFileException("No file to transfer. File is empty.");
//
//        }
//
//        File file = new File(folder, fileName);
//         
//
//        FileOutputStream fos = null;
//        fos = new FileOutputStream(file);
//        fos.write(multipartFile.getBytes());
//        fos.close();
//
//        log.debug("file succesfull uploaded : "+file.getCanonicalPath());
//        return file;
//    }

    /**
     * Return a list of file names contained in a given folder.
     * @param folderPath The path to the folder from wich we retrieve the file names
     * @return the list of file names.
     */
    public static List<String> getFilesNamesIntoFolder(String folderPath){
        
        List<String> files = new ArrayList<String>();
        File folder = new File(folderPath);
        if(!folder.exists()){
            return files;
        }
        if(!folder.isDirectory()){//FIXME if the folderPath ios a path for a file and we want the folder parent so?
            folder = folder.getParentFile();
        }
        files = Arrays.asList(folder.list());
      
        
        return files;
        
    }

    /**
     * Return a list of files contained in a given folder.
     * @param folderPath The path to the folder from wich we retrieve the files
     * @return the list of files.
     */
    public static List<File> getFilesIntoFolder(String folderPath){
        
        List<File> files = new ArrayList<File>();
        File folder = new File(folderPath);
        if(!folder.exists()){
            return files;
        }
        if(!folder.isDirectory()){
            folder = folder.getParentFile();
        }
        files = Arrays.asList(folder.listFiles());
      
        
        return files;
        
    }
    
    /**
     * Return a list of files contained in a given folder.
     * @param folderPath The path to the folder from wich we retrieve the files
     * @param extentions The extentions we filter on. No filtering if null.
     * @return the list of files.
     */
    public static List<File> getFilesFromFolder(String folderPath, final String ... extensions){
        
        List<File> files = new ArrayList<File>();
        File folder = new File(folderPath);
        if(!folder.exists()){
            return files;
        }
        if(!folder.isDirectory()){
            folder = folder.getParentFile();
        }
        
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                for (String extension : extensions) {
                    if(name.toLowerCase().endsWith(extension.toLowerCase())){
                        return true;
                    }
                }
                return false;
            }
        };

        files = Arrays.asList(folder.listFiles(filter));
      
        
        return files;
        
    }
    
    public static int getFolderLength(String folderPath){
        
        File folder = new File(folderPath);
        if(!folder.exists()){
            return 0;
        }
        if(!folder.isDirectory()){
            folder = folder.getParentFile();
        }
        int length = 0;
        List<File> files = Arrays.asList(folder.listFiles());
        for(File file : files){
            if(file.isDirectory()){
                continue;
            }
            length+=file.length();
        }
        return length;
        
    }
    
    public static void writeStringToFile(String dataString, File file) throws IOException {
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        out.print(dataString);
        out.flush();
        out.close();
        
    }
    
    public static File ensureFolderExists(String completeFolderName) {
        File mainFolder = new File(completeFolderName);
        if(!mainFolder.exists()){
            mainFolder.mkdirs();
        }
        return mainFolder;
    }
    
    public static File ensureFileExists(String completeFilePath) { //to ensure compatibility with old code (<java7)
    	return ensureFileExists(Paths.get(completeFilePath)).toFile();
    }
    
    /**
     * check if File exists and create it if not
     * @return Path if file already exist or not
     * @throws RuntimeException in case of {@link IOException}
     */
    public static Path ensureFileExists(Path completeFilePath) {
    	if(Files.exists(completeFilePath)){
    	
    		return completeFilePath;
    	
    	} else {
    		try {
    			return Files.createFile(completeFilePath);
    		} catch (IOException e) {
    			throw new RuntimeException(e);
    		}
    	}
    }
    
    public void saveDataToFile(byte[] data, String fileName, String absoluteFolderPath) throws IOException {
		if (StringUtils.isEmpty(absoluteFolderPath)) {
			throw new IllegalArgumentException("foldernames cannot be empty");
		}
		FileUtil.ensureFolderExists(absoluteFolderPath);
		org.apache.commons.io.FileUtils.writeByteArrayToFile(new File(absoluteFolderPath + File.separator + fileName), data);
	}


	private static int deleteContentOlderThan(File directory, int numberOfDays){
		int count = 0;
		for (File file : directory.listFiles()) {
			if(file.isDirectory()){
				count+= deleteContentOlderThan(file, numberOfDays);
				deleteFileOlderThan(file, numberOfDays);
			} else {
				deleteFileOlderThan(file, numberOfDays);
				count += 1;
			}
		}
		return count;
	}

	private static boolean deleteFileOlderThan(File file, int numberOfDays){
		boolean deleted = false;
		Date lastModified = new Date(file.lastModified());
		if(lastModified.before(DateUtils.addDays(new Date(), -numberOfDays))){
			deleted = file.delete();
			if(!deleted){
			log.warn("Cannot delete file : " + file.getAbsolutePath());
			}
		}
		return deleted;
	}
	
	/**
	 * 
	 * @param path  example: "c:/mydirectory"
	 * @param filePattern example: "12345.*"
	 */
	public static void deleteFilesWithPattern(String pathStr, String filePattern) {  
	    
	    try {
	        Path dir = Paths.get(pathStr);
	        DirectoryStream<Path> dirStream;
	        dirStream = Files.newDirectoryStream(dir, filePattern);
	        for (Path filePath: dirStream) {
	            Files.delete(filePath);
	        }
	    } catch (IOException e) {
	        new RuntimeException("Problem while deleting files "+filePattern+" in path "+pathStr, e);
	    } 
	}



	public static String createTemporaryFolder() {
		String destinationDirectory = System.getProperty("java.io.tmpdir") + UUID.randomUUID().toString() + "/";
		FileUtil.ensureFolderExists(destinationDirectory); 
		return destinationDirectory ;
	}


	private static void copyFiles(String sourcePath, String destinationPath, String ... filterExtensions){
		// If source does not exists returns
		File sourceFolder = new File(sourcePath);
		if(!sourceFolder.exists()){
			log.warn("Copy Files source directory does not exists " + sourcePath);
			return;
		}

		// Create destination directory if needed
		File destinationDir = FileUtil.ensureFolderExists(destinationPath);

		for (File file : FileUtil.getFilesFromFolder(sourcePath, filterExtensions)) {
			String name = file.getName();
			file.renameTo(new File(destinationDir + "/" + name));
		}
	}

    @SuppressWarnings("serial")
    public static class InvalidImageFileException extends Exception {
        private String messageToUser;
        InvalidImageFileException(String userMsg) {
            this.messageToUser = userMsg;
        }
        public String getMessageToUser() {
            return messageToUser;
        }
    }
    
    @SuppressWarnings("serial")
    public static class deleteFileException extends Exception {
        private String messageToUser;
        deleteFileException(String userMsg) {
            this.messageToUser = userMsg;
        }
        public String getMessageToUser() {
            return messageToUser;
        }
    }
    
}
