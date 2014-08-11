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

package de.fhg.fokus.odp.registry.model;

// TODO: Auto-generated Javadoc
/**
 * The Interface Resource.
 * 
 * @author sim
 */
public interface Resource {

	/**
     * Gets the id.
     * 
     * @return the id
     */
    public String getId();
	
    /**
     * Gets the url.
     * 
     * @return the url
     */
    public String getUrl();

    /**
     * Sets the url.
     * 
     * @param url
     *            the new url
     */
    public void setUrl(String url);

    /**
     * Gets the format.
     * 
     * @return the format
     */
    public String getFormat();

    /**
     * Sets the format.
     * 
     * @param format
     *            the new format
     */
    public void setFormat(String format);

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription();

    /**
     * Sets the description.
     * 
     * @param description
     *            the new description
     */
    public void setDescription(String description);

    /**
     * Gets the language.
     * 
     * @return the language
     */
    public String getLanguage();

    /**
     * Sets the language.
     * 
     * @param language
     *            the new language
     */
    public void setLanguage(String language);

    /**
     * Gets the hash.
     * 
     * @return the hash
     */
    public String getHash();

    /**
     * Sets the hash.
     * 
     * @param hash
     *            the new hash
     */
    public void setHash(String hash);

    /**
     * Gets the type.
     * 
     * @return the type
     */
    public String getType();

    /**
     * Sets the type.
     * 
     * @param type
     *            the new type
     */
    public void setType(String type);

}
