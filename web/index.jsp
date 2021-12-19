<!DOCTYPE html>
<html lang="es">

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
        <%HttpSession miSession = request.getSession();
          String usu = (String) miSession.getAttribute("user");
          if (usu==null) {
              response.sendRedirect("login.jsp");
          } else { 
        %>

	<!-- Sidebar -->
	<section id="sidebar">
		<div class="inner">
			<nav>
				<ul>
					<li><a href="#intro">Inicio</a></li>
					<li><a href="#one">Empleados</a></li>
					<li><a href="#two">Servicios</a></li>
					<li><a href="#three">Clientes</a></li>
					<li><a href="#four">Ventas</a></li>
                                        <li><a href="#five">Paquetes</a></li>
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
				<p>Sistema de gestión de recursos. Aquí podrás administrar las altas, bajas, modificaciones y lecturas de los diferentes recursos de la agencia de turismo.</p>
				<ul class="actions">
                                    <form action="SvLogout" method="get">
					<li><a href="SvLogout" class="button scrolly">Salir</a></li>
                                    </form>    
				</ul>
			</div>
		</section>

		<!-- One -->
		<!-- Empleados -->
		<section id="one" class="wrapper style2 fade-up">
			<div class="inner">
				<h2>Empleados</h2>
				<br><br><br>
				<div class="features">
					<section>
						<span class="icon solid major fa-code"></span>
						<h3>Alta</h3>
						<p>Ingresá los datos para dar de alta un nuevo empleado con su correspondiente usuario.</p>
						<ul class="actions">
							<li><a href="formularioEmpleado.jsp" class="button">Nuevo empleado</a></li>
						</ul>
					</section>

					<section>
						<span class="icon solid major fa-desktop"></span>
						<h3>Consulta</h3>
                                                <p>Lista de empleados y usuarios. Aquí podrás hacer las bajas y modificaciones necesarias.</p>
						<ul class="actions">
                                                    <form action="SvConsultarEmpleados" method="GET">
							<li><a href="SvConsultarEmpleados" class="button">Ver lista de empleados</a></li>
                                                    </form>    
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
				<br><br><br>
				<div class="features">
					<section>
						<span class="icon solid major fa-code"></span>
						<h3>Alta</h3>
						<p>Ingresá los datos para dar de alta un nuevo servicio.</p>
						<ul class="actions">
							<li><a href="formularioServicio.jsp" class="button">Nuevo servicio</a></li>
						</ul>
					</section>

					<section>
						<span class="icon solid major fa-desktop"></span>
						<h3>Ver servicios</h3>
						<p>Lista de servicios. Aquí podrás hacer las bajas y modificaciones necesarias.</p>
						<ul class="actions">
                                                    <form action="SvConsultarServicios" method="GET">
                                                            <li><a href="SvConsultarServicios" class="button">Ver lista de servicios</a></li>
                                                    </form>
                                                </ul>
					</section>
				</div>
			</div>
		</section>

		<!-- Three -->
		<!-- Clientes -->
		<section id="three" class="wrapper style1 fade-up">
			<div class="inner">
				<h2>Clientes</h2>
				<br><br><br>
				<div class="features">
					<section>
						<span class="icon solid major fa-code"></span>
						<h3>Alta</h3>
						<p>Ingresá los datos para dar de alta un nuevo cliente.</p>
						<ul class="actions">
							<li><a href="formularioCliente.jsp" class="button">Nuevo Cliente</a></li>
						</ul>
					</section>

					<section>
						<span class="icon solid major fa-desktop"></span>
						<h3>Consulta</h3>
						<p>Lista de servicios. Aquí podrás hacer las bajas y modificaciones necesarias.</p>
						<ul class="actions">
						    <form action="SvConsultarClientes" method="GET">
                                                            <li><a href="SvConsultarClientes" class="button">Ver lista de clientes</a></li>
                                                    </form>
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
                                <br><br><br>
				<div class="features">
					<section>
						<span class="icon solid major fa-code"></span>
						<h3>Alta</h3>
						<p>Ingresá los datos para dar de alta una nueva venta.</p>
						<ul class="actions">
                                                    <form action="SvVenta" method="GET">
							<li><a href="SvVenta" class="button">Nueva venta</a></li>
                                                    </form>    
                                                </ul>
					</section>

					<section>
						<span class="icon solid major fa-desktop"></span>
						<h3>Consulta</h3>
						<p>Lista de ventas. Aquí podrás hacer las bajas y modificaciones necesarias.</p>
						<ul class="actions">
                                                    <form action="SvConsultarVentas" method="GET">
                                                            <li><a href="SvConsultarVentas" class="button">Ver lista de ventas</a></li>
                                                    </form>    
                                                </ul>
					</section>
				</div>
			</div>
		</section>
                
                <!-- Five -->
		<!-- Paquetes -->
		<section id="five" class="wrapper style1 fade-up">
			<div class="inner">
				<h2>Paquetes</h2>
				<br><br><br>
				<div class="features">
					<section>
						<span class="icon solid major fa-code"></span>
						<h3>Alta</h3>
						<p>Ingresá los datos para dar de alta un nuevo paquete.</p>
						<ul class="actions">
                                                        <form action="SvPaquete" method="GET">
                                                            <li><a href="SvPaquete" class="button">Nuevo paquete</a></li>
                                                        </form>
						</ul>
					</section>

					<section>
						<span class="icon solid major fa-desktop"></span>
						<h3>Consulta</h3>
						<p>Lista de paquetes. Aquí podrás hacer las bajas y modificaciones necesarias.</p>
						<ul class="actions">
                                                    <form action="SvConsultarPaquetes" method="GET">
                                                            <li><a href="SvConsultarPaquetes" class="button">Ver lista de paquetes</a></li>
                                                    </form>
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
        <%}%>
</body>

</html>