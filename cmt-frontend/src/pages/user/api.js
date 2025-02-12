import axios from "axios";

export function getUser() {
    return axios.get('/v1/users')
}
export function updateUser(userId, body) {
    return axios.put(`/v1/user/${userId}`, body)
}

export function deleteUser(userId) {
    return axios.delete(`/v1/user/${userId}`)
}
export function createUser(body) {
    return axios.post(`/v1/user`, body)
}