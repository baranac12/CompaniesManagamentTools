import { createSlice } from '@reduxjs/toolkit';

const initialState = {
    user: null, // Başlangıçta kullanıcı verisi yok
    isAuthenticated: false,
};

// localStorage'dan kullanıcı bilgisini almak ve geçerli bir JSON olup olmadığını kontrol etmek
const storedUser = localStorage.getItem('user');
let user = null;

try {
    if (storedUser) {
        user = JSON.parse(storedUser);
    }
} catch (error) {
    console.error('localStorage user verisi geçersiz:', error);
}
const authSlice = createSlice({
    name: 'auth',
    initialState: {
        user: user,
        isAuthenticated: user !== null, // Eğer kullanıcı verisi varsa, giriş yapılmış kabul et
    },
    reducers: {
        login: (state, action) => {
            const userData = action.payload;
            // Geçerli bir JSON formatında olduğundan emin olalım
            try {
                localStorage.setItem('user', JSON.stringify(userData));
                state.user = userData;
                state.isAuthenticated = true;
            } catch (error) {
                console.error('localStorage kaydetme hatası:', error);
            }
        },
        logout: (state) => {
            state.user = null;
            state.isAuthenticated = false;
            localStorage.removeItem('user'); // Kullanıcı bilgilerini localStorage'dan sil
        },
    },
});

export const { login, logout } = authSlice.actions;

export default authSlice.reducer;
