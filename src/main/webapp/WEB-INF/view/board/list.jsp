<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<div class="container p-5">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성자</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="post" items="${postsList}">
                <tr>
                    <td>${post.id}</td>
                    <td>${post.title}</td>
                    <td>${post.content}</td>
                    <td>${post.username}</td>
                    <td>
                        <form action="/board/delete" method="post" class="d-inline">
                            <input type="hidden" name="id" value="${post.id}">
                            <button type="submit" name="action" value="delete" class="btn btn-danger">삭제</button>
                        </form>
                        <form action="/board/${post.id}/updateForm" method="get" class="d-inline">
                            <button type="submit" class="btn btn-warning">수정</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- 비밀번호 입력 폼 -->
    <c:if test="${not empty param.id}">
        <div class="card mt-3">
            <div class="card-header"><b>게시글 삭제</b></div>
            <div class="card-body">
                <form action="/board/delete" method="post">
                    <input type="hidden" name="id" value="${param.id}">
                    <div class="mb-3">
                        <input type="password" class="form-control" placeholder="비밀번호" name="password" required>
                    </div>
                    <button type="submit" name="action" value="confirm" class="btn btn-danger">비밀번호 확인 후 삭제</button>
                    <a href="/board/list" class="btn btn-secondary">취소</a>
                </form>
            </div>
        </div>
    </c:if>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
