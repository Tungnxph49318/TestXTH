import axios from "axios";

const API_URL = "/api/nhan-vien";

export const getAll = () => axios.get(API_URL);
export const getPage = (page, size) =>
  axios.get(`${API_URL}/page?page=${page}&size=${size}`);
export const getOne = (id) => axios.get(`${API_URL}/${id}`);
export const create = (data) => axios.post(API_URL, data);
export const update = (id, data) => axios.put(`${API_URL}/${id}`, data);
export const updateTrangThai = (id, data) =>
  axios.put(`${API_URL}/trang-thai/${id}`, data);
export const remove = (id) => axios.delete(`${API_URL}/${id}`);
