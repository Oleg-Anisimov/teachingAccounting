import {createRouter, createWebHistory} from "vue-router";
import Users from "./views/Users.vue";
import Profile from "./views/Profile.vue";
import User from "./model/User";
import UserProfile from "./views/UserProfile.vue";

const data: User[] = [
    {
        id: 1,
        firstName: 'Олег',
        lastName: 'Анисимов',
        password: 'sdflsfjsldjfsdlkf'
    },
    {
        id: 2,
        firstName: 'Олег',
        lastName: 'Анисимов',
        password: 'sdflsfjsldjfsdlkf'
    },
    {
        id: 3,
        firstName: 'Олег',
        lastName: 'Анисимов',
        password: 'sdflsfjsldjfsdlkf'
    }
];

export default createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/user/:id',
            component: UserProfile
        },
        {
            path: '/users',
            component: Users,
            props: {
                users: data
            }
        },
        {
            path: '/profile',
            component: Profile

        }
    ]
})