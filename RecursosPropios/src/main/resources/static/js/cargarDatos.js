function agregarDatos() {
    // Capturamos los valores ingresados en el formulario
    const numOrden = document.getElementById('num-orden').value;
    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const cantPracticas = document.getElementById('cant-practicas').value;
    const codPractica = document.getElementById('cod-practica').value;
    const valorPractica = cantPracticas * codPractica; // Calculamos el valor de la práctica

    // Creamos un objeto con los datos capturados
    const datos = {
      numOrden,
      nombre,
      apellido,
      cantPracticas,
      codPractica,
      valorPractica
    };

    // Enviamos los datos a un archivo Excel
    // (Aquí se puede usar alguna librería de JS para manejar archivos Excel)
    console.log(datos);
  }