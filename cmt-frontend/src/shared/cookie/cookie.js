// cookie.js
import Cookies from 'js-cookie';


// Tokenları oku
export const getToken = (name) => {
  return Cookies.get(name);
};

// Tokenları sil
export const removeToken = (name) => {
  Cookies.remove(name);
};
