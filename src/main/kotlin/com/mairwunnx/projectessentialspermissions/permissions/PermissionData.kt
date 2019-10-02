package com.mairwunnx.projectessentialspermissions.permissions

import com.mairwunnx.projectessentialspermissions.extensions.empty
import kotlinx.serialization.Serializable

/**
 * Base permission data class, it store
 * list of all registered groups and storing
 * list of all registered users.
 * @since 1.14.4-0.1.0.0
 */
@Serializable
data class PermissionData(
    /**
     * stores all registered groups.
     */
    var groups: List<Group> = listOf(
        Group(
            "default",
            true,
            listOf()
        ),
        Group("owner", false, listOf("*"))
    ),
    /**
     * stores all registered users.
     */
    var users: List<User> = listOf(
        User("*", "default", emptyList())
    )
) {
    /**
     * Base group data class, it store:
     * group name, default state, list of permissions.
     */
    @Serializable
    data class Group(
        /**
         * name of group.
         */
        var name: String = String.empty,
        /**
         * stores state is default group
         * for new users.
         */
        var isDefault: Boolean = false,
        /**
         * stores all group permissions.
         */
        var permissions: List<String> = emptyList()
    )

    /**
     * Base user data class, it store:
     * uuid of user, user group, list of
     * additional permissions.
     */
    @Serializable
    data class User(
        /**
         * UUID of player, We use UUIDs to avoid
         * unpleasant situations when changing
         * nicknames to licenses.
         */
        var uuid: String = String.empty,
        /**
         * user group.
         */
        var group: String = String.empty,
        /**
         * stores all user additional permissions.
         */
        var permissions: List<String> = emptyList()
    )
}