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
        <div class="text-danger bg-info">${sessionScope.confim}</div>
        <form method="get" action="/phieu-giam-gia/search">
            <div class="mt-3">
                <label>Ngày bắt đầu</label>
                <input name="ngayBatDau" type="Date" class="form-control"/>
            </div>
            <div class="mt-3">
                <label>Ngày kết thúc</label>
                <input name="ngayKetThuc" type="Date" class="form-control"/>
            </div>
            <div class="mt-3">
                <label>Khách hàng</label>
                <select path="khachHang.maKhachHang" class="form-select">
                    <c:forEach items="${listKH}" var="kh">
                        <option value="${kh.maKhachHang}">${kh.maKhachHang}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mt-3">
                <button class="btn btn-success" type="submit">Search</button>
                <a class="btn btn-primary " href="/phieu-giam-gia/viewAdd">Add</a>
            </div>
        </form>
    </div>
    <div class="col-10 offset-1 mt-3">
        <table class="table table-bordered text-center">
            <thead class="bg-info">
                <tr>
                    <th>Mã</th>
                    <th>Tên phiếu</th>
                    <th>Ngày bắt đầu</th>
                    <th>Ngày kết thúc</th>
                    <th>Giá trị giảm</th>
                    <th>Trạng thái</th>
                    <th>Tên kh</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list.content}" var="pgm">
                    <tr>
                        <td>${pgm.maPhieu}</td>
                        <td>${pgm.tenPhieu}</td>
                        <td>${pgm.ngayBatDau}</td>
                        <td>${pgm.ngayKetThuc}</td>
                        <td>${pgm.giaTriGiam}</td>
                        <td>${pgm.trangThai}</td>
                        <td>${pgm.khachHang.tenKhachHang}</td>
                        <td>
                            <a class="btn btn-primary" href="/phieu-giam-gia/delete/${pgm.maPhieu}">Remove</a>
                            <a class="btn btn-primary" href="/phieu-giam-gia/viewUpdate/${pgm.maPhieu}">Update</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="mt-3">
            <nav>
                <ul class="pagination">
                    <c:forEach begin="0" end="${list.totalPages -1}" varStatus="loop">
                        <li class="page-item" >
                            <a class="page-link" href="/phieu-giam-gia/hien-thi?page=${loop.begin + loop.count-1}">
                                    ${loop.begin + loop.count}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>

    </div>
</div>

</body>
</html>
