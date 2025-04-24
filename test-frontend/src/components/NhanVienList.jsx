import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import * as api from "../services/nhanVienService";
import NhanVienForm from "./NhanVienForm";

function NhanVienList() {
  const [nhanViens, setNhanViens] = useState([]);
  const [selectedNhanVien, setSelectedNhanVien] = useState(null);
  const [page, setPage] = useState(0);
  const navigate = useNavigate();

  const fetchData = async () => {
    try {
      const res = await api.getPage(page, 5);
      setNhanViens(res.data.content);
    } catch (error) {
      console.error("Lỗi khi lấy dữ liệu:", error);
    }
  };

  useEffect(() => {
    fetchData();
  }, [page]);

  const handleSubmit = async (data) => {
    if (data.id) {
      await api.update(data.id, data);
    } else {
      await api.create(data);
    }
    fetchData();
  };

  const handleDelete = async (id) => {
    if (window.confirm("Bạn có chắc muốn xóa?")) {
      await api.remove(id);
      fetchData();
    }
  };

  const handleTrangThai = async (nv) => {
    await api.updateTrangThai(nv.id, {
      ...nv,
      trangThai: nv.trangThai === 1 ? 0 : 1,
    });
    fetchData();
  };

  return (
    <div className="container py-4">
      <div className="shadow p-4 rounded bg-light mb-4">
        <NhanVienForm
          onSubmit={handleSubmit}
          selectedNhanVien={selectedNhanVien}
          setSelectedNhanVien={setSelectedNhanVien}
          nhanViens={nhanViens}
        />
      </div>

      <div className="shadow rounded p-3">
        <table className="table table-bordered table-hover text-center align-middle">
          <thead className="table-primary">
            <tr>
              <th>Tên</th>
              <th>Mã</th>
              <th>TK FE</th>
              <th>TK FPT</th>
              <th>Trạng thái</th>
              <th>Hành động</th>
            </tr>
          </thead>
          <tbody>
            {nhanViens.map((nv) => (
              <tr key={nv.id}>
                <td>{nv.tenNhanVien}</td>
                <td>{nv.maNhanVien}</td>
                <td>{nv.tkFe}</td>
                <td>{nv.tkFpt}</td>
                <td>
                  <span
                    className={`badge ${
                      nv.trangThai === 1 ? "bg-success" : "bg-secondary"
                    }`}
                  >
                    {nv.trangThai === 1 ? "Hoạt động" : "Ngừng hoạt động"}
                  </span>
                </td>
                <td>
                  <button
                    className="btn btn-sm btn-warning me-1"
                    onClick={() => setSelectedNhanVien(nv)}
                  >
                    Sửa
                  </button>
                  <button
                    className="btn btn-sm btn-danger me-1"
                    onClick={() => handleDelete(nv.id)}
                  >
                    Xóa
                  </button>
                  <button
                    className="btn btn-sm btn-info text-white me-1"
                    onClick={() => handleTrangThai(nv)}
                  >
                    Đổi trạng thái
                  </button>
                  <button
                    className="btn btn-sm btn-primary me-1"
                    onClick={() => navigate(`/nhan-vien/${nv.id}`)}
                  >
                    Hiển thị
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>

        <div className="d-flex justify-content-center mt-3">
          <button
            className="btn btn-outline-primary me-2"
            disabled={page === 0}
            onClick={() => setPage((prev) => Math.max(prev - 1, 0))}
          >
            Trang trước
          </button>
          <button
            className="btn btn-outline-primary"
            onClick={() => setPage((prev) => prev + 1)}
          >
            Trang sau
          </button>
        </div>
      </div>
    </div>
  );
}

export default NhanVienList;
