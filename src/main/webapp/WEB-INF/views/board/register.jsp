<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Forms</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Basic Form Elements</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form role="form" method="post">
								<div class="form-group">
									<label>Title</label> <input class="form-control" name="title">
								
								</div>
								<div class="form-group">
									<label>Writer</label> <input
										class="form-control" name="writer" readonly="readonly" value="${userName}">
								</div>
								
							
								<div class="form-group">
									<label>Content area</label>
									<textarea class="form-control" rows="3" name="content"></textarea>
								</div>
								<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
								<input type="submit" value="create" >
								
							</form>
							<a href="/board/list?page=${param.page }"><button>Back</button></a>
							
						</div>
						<!-- /.col-lg-6 (nested) -->
					</div>
					<!-- /.row (nested) -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>
<!-- /#page-wrapper -->

</div>



<%@ include file="/WEB-INF/views/includes/footer.jsp"%>