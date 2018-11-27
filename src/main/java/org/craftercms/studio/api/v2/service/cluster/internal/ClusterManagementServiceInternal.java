/*
 * Copyright (C) 2007-2018 Crafter Software Corporation. All rights reserved.
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

package org.craftercms.studio.api.v2.service.cluster.internal;

import org.craftercms.studio.api.v1.exception.ServiceLayerException;
import org.craftercms.studio.api.v2.dal.ClusterMember;

import java.util.List;

public interface ClusterManagementServiceInternal {

    /**
     * Get all members for cluster
     *
     * @return List of all cluster memebers
     */
    List<ClusterMember> getAllMembers();

    /**
     * Remove members from cluster
     *
     * @param memberIds List of member ids
     * @return true if successful, otherwise false
     */
    boolean removeMembers(List<Long> memberIds);

    /**
     * Add member to the cluster
     *
     * @param clusterMember Cluster member to add
     * @return true if successful, otherwise false
     */
    boolean addMember(ClusterMember clusterMember) throws ServiceLayerException;

    /**
     * Update cluster member
     *
     * @param clusterMember Member to update
     * @return true if successful, otherwise false
     */
    boolean updateMember(ClusterMember clusterMember) throws ServiceLayerException;

    /**
     * Get cluster member by id
     *
     * @param clusterMemberId Member id
     * @return Requested cluster member
     */
    ClusterMember getMember(long clusterMemberId);

    /**
     * Check if member with given url exists in the cluster
     *
     * @param memberUrl URL to check
     * @return true if already exist, otherwise false
     */
    boolean memberExists(String memberUrl);
}