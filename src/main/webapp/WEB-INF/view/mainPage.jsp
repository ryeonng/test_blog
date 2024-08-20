<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout/header.jsp" %>

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
            <!-- 샘플 게시글 -->
            <tr>
                <td>1</td>
                <td>제목1</td>
                <td>내용1</td>
                <td>홍길동</td>
                <td>
                    <div class="d-flex">
                        <form action="/deletePost" method="post">
                            <input type="hidden" name="id" value="1">
                            <button class="btn btn-danger">삭제</button>
                        </form>
                        <form action="/board/1/updateForm" method="get">
                            <button class="btn btn-warning">수정</button>
                        </form>
                    </div>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>제목2</td>
                <td>내용2</td>
                <td>홍길동</td>
                <td>
                    <div class="d-flex">
                        <form action="/deletePost" method="post">
                            <input type="hidden" name="id" value="2">
                            <button class="btn btn-danger">삭제</button>
                        </form>
                        <form action="/board/2/updateForm" method="get">
                            <button class="btn btn-warning">수정</button>
                        </form>
                    </div>
                </td>
            </tr>
            <!-- 추가 게시글은 여기에 추가 가능합니다 -->
        </tbody>
    </table>
</div>

<%@ include file="layout/footer.jsp" %>
