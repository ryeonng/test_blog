<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<div class="container p-5">
    <div class="card">
        <div class="card-header"><b>게시물 수정하기</b></div>
        <div class="card-body">
            <form action="/board/update" method="post">
                <input type="hidden" name="id" value="${post.id}">
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Enter author" name="author" value="${post.username}" required>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Enter title" name="title" value="${post.title}" required>
                </div>
                <div class="mb-3">
                    <textarea class="form-control" rows="5" name="content" required>${post.content}</textarea>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" placeholder="Enter password" name="password" required>
                </div>
                <button type="submit" class="btn btn-primary form-control">글수정완료</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
