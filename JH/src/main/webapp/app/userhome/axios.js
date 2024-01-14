import axios from 'axios';
const token = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcwNTEyNjkyMSwiYXV0aCI6IlJPTEVfQURNSU4gUk9MRV9VU0VSIiwiaWF0IjoxNzA1MDQwNTIxfQ.hn5Oma6blpCxN2uHBfOhHCQpkdjEzQJ44t33cLKLSy3CtRrFgeNRTMXK_pLwRTejf5BWz6obGmCHW0ztNpfw4A'

const instance = axios.create({
  baseURL: 'http://localhost:8080',
  headers:{
    accept: '*/*',
    // Authorization: `Bearer ${token}`
  }
});

export default instance;
