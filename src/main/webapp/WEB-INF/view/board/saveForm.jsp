<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<div class="container p-5">
    <div class="card">
        <div class="card-header"><b>게시글 작성</b></div>
        <div class="card-body">
            <form action="/board/save" method="post">
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="작성자" name="username" required>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" placeholder="비밀번호" name="password" required>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="제목" name="title" required>
                </div>
                <div class="mb-3">
                    <textarea class="form-control" rows="5" name="content" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary form-control">글쓰기 완료</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
