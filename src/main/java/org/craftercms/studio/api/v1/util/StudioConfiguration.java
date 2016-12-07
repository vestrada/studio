/*
 * Crafter Studio Web-content authoring solution
 * Copyright (C) 2007-2016 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.craftercms.studio.api.v1.util;

public interface StudioConfiguration {
    public static final String LOAD_ADDITIONAL_CONFIGURATION = "load-additional-configuration";
    public static final String REPO_BASE_PATH = "repo-base-path";
    public static final String GLOBAL_REPO_PATH = "global-repo-path";
    public static final String SITES_REPOS_PATH = "sites-repos-path";
    public static final String SANDBOX_PATH = "sandbox-path";
    public static final String PUBLISHED_PATH = "published-path";
    public static final String BLUE_PRINTS_PATH = "blue-prints-path";

    // Methods
    void loadConfiguration();

    String getProperty(String key);
}