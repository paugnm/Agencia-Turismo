<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<title>Agencia de turismo</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="assets/css/main.css" />
	<noscript>
		<link rel="stylesheet" href="assets/css/noscript.css" />
	</noscript>
</head>

<body class="is-preload">

	<!-- Sidebar -->
	<section id="sidebar">
		<div class="inner">
			<nav>
				<ul>
					<li><a href="#intro">Inicio</a></li>
					<li><a href="#one">Empleados</a></li>
					<li><a href="#two">Servicios</a></li>
					<li><a href="#three">Paquetes</a></li>
					<li><a href="#four">Ventas</a></li>
				</ul>
			</nav>
		</div>
	</section>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Intro -->
		<section id="intro" class="wrapper style1 fullscreen fade-up">
			<div class="inner">
				<h1>Bienvenido</h1>
				<p>Just another fine responsive site template designed by <a href="http://html5up.net">HTML5
						UP</a><br />
					and released for free under the <a href="http://html5up.net/license">Creative Commons</a>.</p>
				<ul class="actions">
					<li><a href="#one" class="button scrolly">Learn more</a></li>
				</ul>
			</div>
		</section>

		<!-- One -->
		<!-- Empleados -->
		<section id="one" class="wrapper style2 fade-up">
			<div class="inner">
				<h2>Empleados</h2>
				<p>Phasellus convallis elit id ullamcorper pulvinar. Duis aliquam turpis mauris, eu ultricies erat
					malesuada quis. Aliquam dapibus, lacus eget hendrerit bibendum, urna est aliquam sem, sit amet
					imperdiet est velit quis lorem.</p>
				<div class="features">
					<section>
						<span class="icon solid major fa-code"></span>
						<h3>Alta</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="formularioEmpleado.jsp" class="button">Nuevo empleado</a></li>
						</ul>
					</section>
					<section>
						<span class="icon solid major fa-lock"></span>
						<h3>Baja</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Dar de baja</a></li>
						</ul>
					</section>
					<section>
						<span class="icon solid major fa-cog"></span>
						<h3>Modificación</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Modificar cliente</a></li>
						</ul>
					</section>
					<section>
						<span class="icon solid major fa-desktop"></span>
						<h3>Consulta</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Consultar</a></li>
						</ul>
					</section>
				</div>
			</div>
		</section>

		<!-- Two -->
		<!-- Servicios -->
		<section id="two" class="wrapper style3 fade-up">
			<div class="inner">
				<h2>Servicios</h2>
				<p>Phasellus convallis elit id ullamcorper pulvinar. Duis aliquam turpis mauris, eu ultricies erat
					malesuada quis. Aliquam dapibus, lacus eget hendrerit bibendum, urna est aliquam sem, sit amet
					imperdiet est velit quis lorem.</p>
				<div class="features">
					<section>
						<span class="icon solid major fa-code"></span>
						<h3>Alta</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="formularioServicio.jsp" class="button">Nuevo servicio</a></li>
						</ul>
					</section>
					<section>
						<span class="icon solid major fa-lock"></span>
						<h3>Baja</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Eliminar servicio</a></li>
						</ul>
					</section>
					<section>
						<span class="icon solid major fa-cog"></span>
						<h3>Modificación</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Modificar servicio</a></li>
						</ul>
					</section>
					<section>
						<span class="icon solid major fa-desktop"></span>
						<h3>Ver servicios</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
                                                    <form action="SvConsultarServicios" method="GET">
                                                            <li><a href="SvConsultarServicios" class="button">Ver servicios</a></li>
                                                        </form>
                                                </ul>
					</section>
				</div>
			</div>
		</section>

		<!-- Three -->
		<!-- Paquetes -->
		<section id="three" class="wrapper style1 fade-up">
			<div class="inner">
				<h2>Paquetes</h2>
				<p>Phasellus convallis elit id ullamcorper pulvinar. Duis aliquam turpis mauris, eu ultricies erat
					malesuada quis. Aliquam dapibus, lacus eget hendrerit bibendum, urna est aliquam sem, sit amet
					imperdiet est velit quis lorem.</p>
				<div class="features">
					<section>
						<span class="icon solid major fa-code"></span>
						<h3>Alta</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Nuevo paquete</a></li>
						</ul>
					</section>
					<section>
						<span class="icon solid major fa-lock"></span>
						<h3>Baja</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Eliminar paquete</a></li>
						</ul>
					</section>
					<section>
						<span class="icon solid major fa-cog"></span>
						<h3>Modificación</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Modificar</a></li>
						</ul>
					</section>
					<section>
						<span class="icon solid major fa-desktop"></span>
						<h3>Consulta</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Consultar</a></li>
						</ul>
					</section>
				</div>
			</div>
		</section>
		

		<!-- Four -->
		<!-- Ventas -->
		<section id="four" class="wrapper style2 fade-up">
			<div class="inner">
				<h2>Ventas</h2>
				<p>Phasellus convallis elit id ullamcorper pulvinar. Duis aliquam turpis mauris, eu ultricies erat
					malesuada quis. Aliquam dapibus, lacus eget hendrerit bibendum, urna est aliquam sem, sit amet
					imperdiet est velit quis lorem.</p>
				<div class="features">
					<section>
						<span class="icon solid major fa-code"></span>
						<h3>Alta</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Nueva venta</a></li>
						</ul>
					</section>
					<section>
						<span class="icon solid major fa-lock"></span>
						<h3>Baja</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Eliminar venta</a></li>
						</ul>
					</section>
					<section>
						<span class="icon solid major fa-cog"></span>
						<h3>Modificación</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Modificar</a></li>
						</ul>
					</section>
					<section>
						<span class="icon solid major fa-desktop"></span>
						<h3>Consulta</h3>
						<p>Phasellus convallis elit id ullam corper amet et pulvinar. Duis aliquam turpis mauris, sed
							ultricies erat dapibus.</p>
						<ul class="actions">
							<li><a href="generic.html" class="button">Consultar</a></li>
						</ul>
					</section>
				</div>
			</div>
		</section>

	</div>


	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>

</html>