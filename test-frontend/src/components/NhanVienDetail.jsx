import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import * as api from "../services/nhanVienService";

function NhanVienDetail() {
  const { id } = useParams();
  const [nhanVien, setNhanVien] = useState(null);
  const [coSoList, setCoSoList] = useState([]);
  const [khoaList, setKhoaList] = useState([]);
  const [nganhList, setNganhList] = useState([]);
  const [selected, setSelected] = useState({
    coSo: "",
    khoa: "",
    nganh: "",
  });
  const [links, setLinks] = useState([]);

  useEffect(() => {
    const fetchNhanVien = async () => {
      try {
        const res = await api.getOne(id);
        setNhanVien(res.data);
      } catch (error) {
        console.error("Lỗi khi lấy chi tiết:", error);
      }
    };
    fetchNhanVien();
    fetchCoSo();
    fetchLinks();
  }, [id]);

  const fetchCoSo = async () => {
    const res = await api.getAllCoSo();
    setCoSoList(res.data);
  };

  const fetchKhoa = async (idCoSo) => {
    const res = await api.getKhoaByCoSo(idCoSo);
    setKhoaList(res.data);
  };

  const fetchNganh = async (idKhoa) => {
    const res = await api.getNganhByKhoa(idKhoa);
    setNganhList(res.data);
  };

  const fetchLinks = async () => {
    const res = await api.getLkNhanVien(id);
    setLinks(res.data);
  };

  const handleChangeCoSo = (e) => {
    const idCoSo = e.target.value;
    setSelected({ coSo: idCoSo, khoa: "", nganh: "" });
    fetchKhoa(idCoSo);
    setNganhList([]);
  };

  const handleChangeKhoa = (e) => {
    const idKhoa = e.target.value;
    setSelected((prev) => ({ ...prev, khoa: idKhoa, nganh: "" }));
    fetchNganh(idKhoa);
  };

  const handleChangeNganh = (e) => {
    setSelected((prev) => ({ ...prev, nganh: e.target.value }));
  };

  const handleAddLink = async () => {
    if (selected.coSo && selected.khoa && selected.nganh) {
      await api.addLkNhanVien({
        idCanBo: id,
        idCoSo: selected.coSo,
        idKhoa: selected.khoa,
        idNganh: selected.nganh,
      });
      fetchLinks();
    }
  };

  if (!nhanVien)
    return <div className="text-center mt-5">Đang tải dữ liệu...</div>;

  return (
    <>
      <div className="container mt-5">
        <div className="shadow p-4 rounded bg-light">
          <h4 className="mb-4">Thông tin nhân viên</h4>
          <p>
            <strong>Tên:</strong> {nhanVien.tenNhanVien}
          </p>
          <p>
            <strong>Mã:</strong> {nhanVien.maNhanVien}
          </p>
          <p>
            <strong>Email FE:</strong> {nhanVien.tkFe}
          </p>
          <p>
            <strong>Email FPT:</strong> {nhanVien.tkFpt}
          </p>
        </div>
      </div>
      <br />
      <br />

      <div className="card shadow p-3 mb-4">
        <h5>Thêm cơ sở - khoa - ngành</h5>
        <div className="row">
          <div className="col-md-4 mb-2">
            <label>Cơ sở</label>
            <select
              className="form-select"
              value={selected.coSo}
              onChange={handleChangeCoSo}
            >
              <option value="">Chọn cơ sở</option>
              {coSoList.map((c) => (
                <option key={c.id} value={c.id}>
                  {c.ten}
                </option>
              ))}
            </select>
          </div>
          <div className="col-md-4 mb-2">
            <label>Khoa</label>
            <select
              className="form-select"
              value={selected.khoa}
              onChange={handleChangeKhoa}
            >
              <option value="">Chọn khoa</option>
              {khoaList.map((k) => (
                <option key={k.id} value={k.id}>
                  {k.ten}
                </option>
              ))}
            </select>
          </div>
          <div className="col-md-4 mb-2">
            <label>Ngành</label>
            <select
              className="form-select"
              value={selected.nganh}
              onChange={handleChangeNganh}
            >
              <option value="">Chọn ngành</option>
              {nganhList.map((n) => (
                <option key={n.id} value={n.id}>
                  {n.ten}
                </option>
              ))}
            </select>
          </div>
        </div>
        <button className="btn btn-success mt-2" onClick={handleAddLink}>
          Thêm liên kết
        </button>
      </div>

      <table className="table table-bordered shadow text-center">
        <thead className="table-light">
          <tr>
            <th>STT</th>
            <th>Cơ sở</th>
            <th>Khoa</th>
            <th>Ngành</th>
          </tr>
        </thead>
        <tbody>
          {links.map((lk, index) => (
            <tr key={lk.id}>
              <td>{index + 1}</td>
              <td>{lk.coSo.ten}</td>
              <td>{lk.khoa.ten}</td>
              <td>{lk.nganh.ten}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}

export default NhanVienDetail;
