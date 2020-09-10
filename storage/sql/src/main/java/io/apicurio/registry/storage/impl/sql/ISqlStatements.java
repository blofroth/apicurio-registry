/*
 * Copyright 2020 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.registry.storage.impl.sql;

import java.util.List;

/**
 * Returns SQL statements used by the JDB storage implementation.  There are different
 * implementations of this interface depending on the database being used.
 * @author eric.wittmann@gmail.com
 */
public interface ISqlStatements {

    /**
     * Gets the database type associated with these statements.
     */
    public String dbType();

    /**
     * Returns true if the given exception represents a primary key violation.
     * @param error
     */
    public boolean isPrimaryKeyViolation(Exception error);

    /**
     * A statement that returns 'true' if the database has already been initialized.
     */
    public String isDatabaseInitialized();

    /**
     * A sequence of statements needed to initialize the database.
     */
    public List<String> databaseInitialization();

    /**
     * A sequence of statements needed to upgrade the DB from one version to another.
     *
     * @param fromVersion
     * @param toVersion
     */
    public List<String> databaseUpgrade(int fromVersion, int toVersion);

    /**
     * A statement that returns the current DB version (pulled from the "apicurio" attribute table).
     */
    public String getDatabaseVersion();

    /**
     * A statement used to insert a row into the globalrules table.
     */
    public String insertGlobalRule();

    /**
     * A statement used to select all global rules.
     */
    public String selectGlobalRules();

    /**
     * A statement used to select a single global rule by its type/id.
     */
    public String selectGlobalRuleByType();

    /**
     * A statement used to delete a row from the globalrules table.
     */
    public String deleteGlobalRule();

    /**
     * A statement used to delete all rows in the globalrules table.
     */
    public String deleteGlobalRules();

    /**
     * A statement used to update information about a global rule.
     */
    public String updateGlobalRule();

    /**
     * A statement used to insert a row in the artifacts table.
     */
    public String insertArtifact();

    /**
     * A statement used to update the 'latest' column of the 'artifacts' table.
     */
    public String updateArtifactLatestVersion();

    /**
     * A statement used to insert a row in the versions table.
     */
    public String insertVersion(boolean firstVersion);

    /**
     * A statement used to select a single row in the versions table by globalId.
     */
    public String selectArtifactVersionMetaDataByGlobalId();

    /**
     * A statement to select the content of an artifact version from the versions table by globalId.
     */
    public String selectArtifactVersionContentByGlobalId();

    /**
     * A statement used to select all version #s for a given artifactId.
     */
    public String selectArtifactVersions();

    /**
     * A statement used to select artifact version metadata by artifactId and version.
     */
    public String selectArtifactVersionMetaData();

    /**
     * A statement to select the content of an artifact version from the versions table by artifactId + version.
     */
    public String selectArtifactVersionContent();

    /**
     * A statement to "upsert" a row in the "content" table.
     */
    public String upsertContent();

    /**
     * A statement to get a single artifact (latest version) content by artifactId.
     */
    public String selectLatestArtifactContent();

    /**
     * A statement to get a single artifact (latest version) meta-data by artifactId.
     */
    public String selectLatestArtifactMetaData();

    /**
     * A statement to select the contentId of a row in the content table by hash value.
     */
    public String selectContentIdByHash();

    /**
     * A statement used to select artifact rules by artifactId.
     */
    public String selectArtifactRules();

    /**
     * A statement to insert a row into the 'rules' table (artifact rule).
     */
    public String insertArtifactRule();

}