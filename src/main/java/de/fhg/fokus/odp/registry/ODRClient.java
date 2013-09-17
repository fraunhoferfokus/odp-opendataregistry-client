/**
 * Copyright (c) 2012, 2013 Fraunhofer Institute FOKUS
 *
 * This file is part of Open Data Platform.
 *
 * Open Data Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Open Data Plaform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.

 * You should have received a copy of the GNU Affero General Public License
 * along with Open Data Platform.  If not, see <http://www.gnu.org/licenses/agpl-3.0>.
 */

package de.fhg.fokus.odp.registry;

import java.util.List;
import java.util.Properties;

import de.fhg.fokus.odp.registry.model.Application;
import de.fhg.fokus.odp.registry.model.Category;
import de.fhg.fokus.odp.registry.model.Dataset;
import de.fhg.fokus.odp.registry.model.Document;
import de.fhg.fokus.odp.registry.model.Licence;
import de.fhg.fokus.odp.registry.model.Metadata;
import de.fhg.fokus.odp.registry.model.MetadataEnumType;
import de.fhg.fokus.odp.registry.model.Resource;
import de.fhg.fokus.odp.registry.model.Tag;
import de.fhg.fokus.odp.registry.model.User;
import de.fhg.fokus.odp.registry.model.exception.OpenDataRegistryException;
import de.fhg.fokus.odp.registry.queries.Query;
import de.fhg.fokus.odp.registry.queries.QueryResult;

/**
 * The Interface ODRClient.
 * 
 * @author sim
 */
public interface ODRClient {

    /**
     * Inits the client implementation.
     * 
     * @throws OpenDataRegistryException
     *             If the implementation could not be initialized properly.
     */
    void init() throws OpenDataRegistryException;

    /**
     * Inits the client implementation with a set of properties. In case of the standard CKAN implementation the following properties can be set:
     * 
     * <pre>
     *   ckan.url
     *   ckan.authorization.key
     * </pre>
     * 
     * @param props
     *            the list of properties.
     */
    void init(Properties props);

    /**
     * Status. General status as String. The format and the contained information depend on the implementation. In case of the default CKAN implementation this
     * is a JSON Object with standard CKAn Server information.
     * 
     * @return the status string
     */
    String status();

    /**
     * List categories.
     * 
     * @return the list of categories
     */
    List<Category> listCategories();

    /**
     * List licenses.
     * 
     * @return the list of licenses
     */
    List<Licence> listLicenses();

    /**
     * List tags.
     * 
     * @return the list
     */
    List<Tag> listTags();

    /**
     * Gets the tag counts.
     * 
     * @return the tag counts
     */
    List<Tag> getTagCounts();

    /**
     * Gets the tag.
     * 
     * @param name
     *            the name
     * @return the tag
     */
    Tag getTag(String name);

    /**
     * Gets the metadata.
     * 
     * @param user
     *            the user
     * @param name
     *            the name
     * @return the metadata
     * @throws OpenDataRegistryException
     *             the open data registry exception
     */
    Metadata getMetadata(User user, String name) throws OpenDataRegistryException;

    /**
     * Query metadata.
     * 
     * @param query
     *            the query
     * @return the query result
     */
    QueryResult<Metadata> queryMetadata(Query query);

    /**
     * Query datasets.
     * 
     * @param query
     *            the query
     * @return the query result
     */
    QueryResult<Dataset> queryDatasets(Query query);

    /**
     * Query applications.
     * 
     * @param query
     *            the query
     * @return the query result
     */
    QueryResult<Application> queryApplications(Query query);

    /**
     * Query documents.
     * 
     * @param query
     *            the query
     * @return the query result
     */
    QueryResult<Document> queryDocuments(Query query);

    /**
     * Find user.
     * 
     * @param name
     *            the name
     * @return the user
     */
    User findUser(String name);

    /**
     * Creates the user.
     * 
     * @param name
     *            the name
     * @param email
     *            the email
     * @param password
     *            the password
     * @return the user
     */
    User createUser(String name, String email, String password);

    /**
     * Show roles.
     * 
     * @param user
     *            the user
     * @param metadata
     *            the metadata
     * @return the list
     */
    List<String> showRoles(User user, String metadata);

    void updateRoles(User user, String object, List<String> roles);

    /**
     * Rate metadata.
     * 
     * @param user
     *            the user
     * @param metadata
     *            the metadata
     * @param rate
     *            the rate
     */
    void rateMetadata(User user, String metadata, int rate);

    /**
     * Load rating.
     * 
     * @param metadata
     *            the metadata
     */
    void loadRating(Metadata metadata);

    /**
     * Auto suggest metadata.
     * 
     * @param fragment
     *            the fragment
     * @return the list
     */
    List<String> autoSuggestMetadata(String fragment);

    /**
     * Auto suggest tags.
     * 
     * @param fragment
     *            the fragment
     * @return the list
     */
    List<String> autoSuggestTags(String fragment);

    /**
     * Auto suggest formats.
     * 
     * @param fragment
     *            the fragment
     * @return the list
     */
    List<String> autoSuggestFormats(String fragment);

    /**
     * Creates the metadata.
     * 
     * @param type
     *            the type
     * @return the metadata
     */
    Metadata createMetadata(MetadataEnumType type);

    /**
     * Persist metadata.
     * 
     * @param user
     *            the user
     * @param metadata
     *            the metadata
     * @throws OpenDataRegistryException
     *             the open data registry exception
     */
    void persistMetadata(User user, Metadata metadata) throws OpenDataRegistryException;

    /**
     * Creates the resource.
     * 
     * @return the resource
     */
    Resource createResource();

    /**
     * Munge title to name.
     * 
     * @param title
     *            the title
     * @return the string
     */
    String mungeTitleToName(String title);

}
