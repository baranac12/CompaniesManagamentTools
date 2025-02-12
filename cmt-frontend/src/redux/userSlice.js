// userSlice.js
import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    users: [],  // Burada başlangıçta users bir dizi olmalı
};

const userSlice = createSlice({
    name: "users",
    initialState,
    reducers: {
        setUsers: (state, action) => {
            state.users = action.payload;  // payload bir dizi olmalı
        },
        dropUser: (state) => {
            state.users = [];  // Reset users to an empty array
        },
        updateUserInStore: (state, action) => {
            // state.users'ın bir dizi olup olmadığını kontrol et
            if (Array.isArray(state.users)) {
                const updatedUserIndex = state.users.findIndex(user => user.id === action.payload.id);
                if (updatedUserIndex !== -1) {
                    state.users[updatedUserIndex] = { ...state.users[updatedUserIndex], ...action.payload };
                }
            } else {
                console.error("state.users bir dizi değil:", state.users);
            }
        },
    },
});

export const { setUsers, dropUser, updateUserInStore } = userSlice.actions;

export default userSlice.reducer;
