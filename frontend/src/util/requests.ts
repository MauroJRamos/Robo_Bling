import axios, { AxiosRequestConfig } from 'axios';
//import qs from 'qs';
//import history from './history';
//https://c54b-2804-1530-109-f31-fd06-9306-bec6-4e6e.ngrok-free.app
//http://localhost:8080
//export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? 'https://c54b-2804-1530-109-f31-fd06-9306-bec6-4e6e.ngrok-free.app'
export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? 'https://d386-2804-1530-109-f31-885a-59f6-715f-a79f.ngrok-free.app'

export const requestBackend = (config: AxiosRequestConfig) => {
    const headers = config.withCredentials
      ? {
          ...config.headers,
         // Authorization: 'Bearer ' + getAuthData().access_token,
        }
      : config.headers;
  
    return axios({ ...config, baseURL: BASE_URL, headers });
  };