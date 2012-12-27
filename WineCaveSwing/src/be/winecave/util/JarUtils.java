/*
 * Copyright (C) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package be.winecave.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarUtils {

	/**
	 * Returns the jar file used to load class clazz, or defaultJar if clazz was not loaded from a
	 * jar.
	 */
	public static JarFile jarForClass(Class<?> clazz, JarFile defaultJar) throws MalformedURLException, URISyntaxException {
		String path = "/" + clazz.getName().replace('.', '/') + ".class";
		URL jarUrl = clazz.getResource(path);
		if (jarUrl == null) {
			return defaultJar;
		}

		String url = jarUrl.toString();
		int bang = url.indexOf("!");
		String JAR_URI_PREFIX = "jar:file:";
		if (url.startsWith(JAR_URI_PREFIX) && bang != -1) {
			try {
				return new JarFile(FileUtil.getJarLocation().toFile());
			} catch (IOException e) {
				throw new IllegalStateException("Error loading jar file.", e);
			}
		} else {
			return defaultJar;
		}
	}

	/**
	 * copies a directory form a jar file in the parent directory of the jar
	 */
	public static void addRessourcesNextJar(JarFile fromJar, String jarRessource,boolean overwriteIfExists) throws IOException {
		Path dest = FileUtil.getInstallationFolder().resolve(jarRessource);
		if( !Files.exists(dest) || overwriteIfExists) {
			copyResourcesToDirectory(fromJar, jarRessource, dest.toString());
		}
	}

	/**
	 * Copies a directory from a jar file to an external directory.
	 */
	public static void copyResourcesToDirectory(JarFile fromJar, String jarDir, String destDir)
			throws IOException {
		for (Enumeration<JarEntry> entries = fromJar.entries(); entries.hasMoreElements();) {
			JarEntry entry = entries.nextElement();
			if (entry.getName().startsWith(jarDir + "/") && !entry.isDirectory()) {
				File dest = new File(destDir + "/" + entry.getName().substring(jarDir.length() + 1));
				File parent = dest.getParentFile();
				if (parent != null) {
					parent.mkdirs();
				}

				FileOutputStream out = new FileOutputStream(dest);
				InputStream in = fromJar.getInputStream(entry);

				try {
					byte[] buffer = new byte[8 * 1024];

					int s = 0;
					while ((s = in.read(buffer)) > 0) {
						out.write(buffer, 0, s);
					}
				} catch (IOException e) {
					throw new IOException("Could not copy asset from jar file", e);
				} finally {
					try {
						in.close();
					} catch (IOException ignored) {}
					try {
						out.close();
					} catch (IOException ignored) {}
				}
			}
		}

	}

	private JarUtils() {} // non-instantiable
}
