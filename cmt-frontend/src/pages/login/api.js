import axios from "axios";

export function loginUser(body) {
    return axios.post('/v1/auth/login', body)
}
export function logoutUser() {
    return axios.post('/v1/auth/logout')
}