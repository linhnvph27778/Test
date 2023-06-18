<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="col-4 offset-4 mt-3">
        <sf:form method="post" action="${action}" modelAttribute="phieuGiamGia">
<%--        <sf:form method="post" action="/phieu-giam-gia/update/${maPhieu}" modelAttribute="phieuGiamGia">--%>
            <div class="mt-3">
                <label>Mã phiếu</label>
                <form:input path="maPhieu" cssClass="form-control"/>
                <form:errors cssClass="text-danger" path="tenPhieu" element="span"/>
            </div>
            <div class="mt-3">
                <label>Tên phiếu</label>
                <form:input path="tenPhieu" cssClass="form-control"/>
                <form:errors cssClass="text-danger" path="tenPhieu" element="span"/>
            </div>
            <div class="mt-3">
                <label>Ngày bắt đầu</label>
                <form:input path="ngayBatDau" type="Date" cssClass="form-control"/>
                <form:errors cssClass="text-danger" path="ngayBatDau" element="span"/>
            </div>
            <div class="mt-3">
                <label>Ngày kết thúc</label>
                <form:input path="ngayKetThuc" type="Date" cssClass="form-control"/>
                <form:errors cssClass="text-danger" path="ngayKetThuc" element="span"/>
                <span class="text-danger">${mes}</span>
            </div>
            <div class="mt-3">
                <label>Giá trị giảm</label>
                <form:input path="giaTriGiam" cssClass="form-control"/>
                <form:errors cssClass="text-danger" path="giaTriGiam" element="span"/>
            </div>

            <div class="mt-3">
                <label>Trạng thái</label>
                <form:radiobutton path="trangThai" value="1" checked="true" cssClass="form-check-input"/> Kết thúc
                <form:radiobutton path="trangThai" value="2" cssClass="form-check-input"/> Đang diễn ra
            </div>

            <div class="mt-3">
                <label>Khách hàng</label>
                <form:select path="khachHang.maKhachHang" cssClass="form-select">
                    <c:forEach items="${listKH}" var="kh">
                        <form:option value="${kh.maKhachHang}">${kh.maKhachHang}</form:option>

                    </c:forEach>
                </form:select>
                <div>${khachHang.tenKhachHang}</div>
            </div>
            <div class="mt-3">

                <button class="btn btn-success" type="submit">Update</button>
            </div>
        </sf:form>
    </div>

</div>

</body>
</html>
