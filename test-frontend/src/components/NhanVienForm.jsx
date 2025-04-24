import React, { useState, useEffect } from "react";

const initialState = {
  tenNhanVien: "",
  maNhanVien: "",
  tkFe: "",
  tkFpt: "",
  trangThai: 1,
};

function NhanVienForm({
  onSubmit,
  selectedNhanVien,
  setSelectedNhanVien,
  nhanViens,
}) {
  const [formData, setFormData] = useState(initialState);
  const [errors, setErrors] = useState({});

  useEffect(() => {
    if (selectedNhanVien) {
      setFormData(selectedNhanVien);
    }
  }, [selectedNhanVien]);

  const validate = () => {
    const errs = {};
    const { tenNhanVien, maNhanVien, tkFe, tkFpt } = formData;

    if (!tenNhanVien.trim()) errs.tenNhanVien = "Tên không được bỏ trống";
    if (!maNhanVien.trim()) errs.maNhanVien = "Mã không được bỏ trống";
    if (!tkFe.trim()) errs.tkFe = "Email FE không được bỏ trống";
    if (!tkFpt.trim()) errs.tkFpt = "Email FPT không được bỏ trống";

    const regexFe = /^[^\s\u00C0-\u1EF9]+@fe\.edu\.vn$/;
    const regexFpt = /^[^\s\u00C0-\u1EF9]+@fpt\.edu\.vn$/;

    if (!regexFe.test(tkFe)) errs.tkFe = "Email FE phải đúng định dạng";
    if (!regexFpt.test(tkFpt)) errs.tkFpt = "Email FPT phải đúng định dạng";

    const duplicate = nhanViens.find(
      (nv) =>
        nv.id !== formData.id &&
        (nv.maNhanVien === maNhanVien || nv.tkFe === tkFe || nv.tkFpt === tkFpt)
    );
    if (duplicate) {
      if (duplicate.maNhanVien === maNhanVien)
        errs.maNhanVien = "Mã đã tồn tại";
      if (duplicate.tkFe === tkFe) errs.tkFe = "Email FE đã tồn tại";
      if (duplicate.tkFpt === tkFpt) errs.tkFpt = "Email FPT đã tồn tại";
    }

    setErrors(errs);
    return Object.keys(errs).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      onSubmit(formData);
      setFormData(initialState);
      setSelectedNhanVien(null);
      setErrors({});
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  return (
    <div className="card shadow p-4 mb-4">
      <h5 className="mb-3">Thông tin nhân viên</h5>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Tên nhân viên</label>
          <input
            type="text"
            name="tenNhanVien"
            className={`form-control ${errors.tenNhanVien ? "is-invalid" : ""}`}
            value={formData.tenNhanVien}
            onChange={handleChange}
          />
          {errors.tenNhanVien && (
            <div className="invalid-feedback">{errors.tenNhanVien}</div>
          )}
        </div>

        <div className="mb-3">
          <label className="form-label">Mã nhân viên</label>
          <input
            type="text"
            name="maNhanVien"
            className={`form-control ${errors.maNhanVien ? "is-invalid" : ""}`}
            value={formData.maNhanVien}
            onChange={handleChange}
          />
          {errors.maNhanVien && (
            <div className="invalid-feedback">{errors.maNhanVien}</div>
          )}
        </div>

        <div className="mb-3">
          <label className="form-label">Tài khoản FE</label>
          <input
            type="text"
            name="tkFe"
            className={`form-control ${errors.tkFe ? "is-invalid" : ""}`}
            value={formData.tkFe}
            onChange={handleChange}
          />
          {errors.tkFe && <div className="invalid-feedback">{errors.tkFe}</div>}
        </div>

        <div className="mb-3">
          <label className="form-label">Tài khoản FPT</label>
          <input
            type="text"
            name="tkFpt"
            className={`form-control ${errors.tkFpt ? "is-invalid" : ""}`}
            value={formData.tkFpt}
            onChange={handleChange}
          />
          {errors.tkFpt && (
            <div className="invalid-feedback">{errors.tkFpt}</div>
          )}
        </div>

        <div className="text-end">
          <button type="submit" className="btn btn-primary px-4">
            {selectedNhanVien ? "Cập nhật" : "Thêm mới"}
          </button>
        </div>
      </form>
    </div>
  );
}

export default NhanVienForm;
