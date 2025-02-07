import { createSlice } from '@reduxjs/toolkit';

const initialState = {
    users: [], // Başlangıçta kullanıcılar boş bir liste
};

const userSlice = createSlice({
    name: 'users',
    initialState,
    reducers: {
        setUsers: (state, action) => {
            state.users = action.payload; // Kullanıcılar listesi payload ile güncellenir
        },
        dropUser: (state) => {
            state.users = []; // Kullanıcıları temizler
        },
    },
});

export const { setUsers, dropUser } = userSlice.actions;

export default userSlice.reducer;
