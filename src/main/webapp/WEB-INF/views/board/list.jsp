

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Tables</h1>
		</div>
		<div>
		<%-- <h2><sec:authentication property="principal.username"/>님 안녕하세요.</h2> --%>
		
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<a href="/board/register?page=${pm.page }"><button>register</button></a>
				</div>
				<form action="/login/logout" method="post">
				<button>Logout</button>
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
				</form>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<table width="100%"
						class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<thead>
							<tr>
								<th>No</th>
								<th>Title</th>
								<th>Writer</th>
								<th>Regdate</th>
							</tr>
						</thead>

						<tbody>

							<c:forEach items="${list }" var="item">
								<tr>
									<td>${item.bno }</td>
									<c:if test="${param.type == null }">
									<td><a href="/board/view?bno=${item.bno }&page=${pm.page}">${item.title }</a></td>
									</c:if>
									<c:if test="${param.type != null }">
									<td><a href="/board/view?bno=${item.bno }&page=${pm.page}&type=${param.type}&keyword=${param.keyword}">${item.title }</a></td>
									</c:if>
									<td>${item.writer }</td>
									<td>${item.regdate }</td>
								</tr>
							</c:forEach>


						</tbody>
					</table>
					<center>
						<form>
							<select name="type" id="type">
								<option value="t">tilte</option>
								<option value="c">content</option>
								<option value="w">writer</option>
								<option value="tc">title+content</option>
								<option value="tw">title+writer</option>
								<option value="tcw">tilte+content+writer</option>
							</select> <input type="text" name="keyword" id="keyword">
							<button>seach</button>
						</form>
						<ul class="pagination">
							<c:if test="${pm.prev }">
								<li><a href="/board/list?page=${pm.start - 1 }">prev</a></li>
							</c:if>
							<c:forEach begin="${pm.start }" end="${pm.end }" var="num">
								<li><a href="/board/list?page=${num }">${num }</a></li>
							</c:forEach>
							<c:if test="${pm.next }">
								<li><a href="/board/list?page=${pm.end + 1 }">next</a></li>
							</c:if>
						</ul>
					</center>
				</div>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
</div>
<!-- /.row -->
</div>
<!-- /#page-wrapper -->

</div>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>

<script>

if(${value eq 'rsuccess'}){
	
	alert("crate success");
	
}
if(${value eq 'dsuccess'}){
	
	alert("remove success");
	
}

$(document).ready(function () {
	$("#type").val("${param.type}");	
	$("#keyword").val("${param.keyword}");
});



</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
