import java.util.*

fun main(args: Array<String>) {
    // INMUTABLES (No se RE ASIGNA "=")
    val inmutable: String = "Adrian";
    // inmutable = "Vicente" // Error!
    // MUTABLES
    var mutable: String = "Vicente"
    mutable = "Adrian" // Ok
    // VAL > VAR


    // Duck Typing
    val ejemploVariable = " Adrian Eguez "
    ejemploVariable.trim()
    val edadEjemplo: Int = 12
    // ejemploVariable = edadEjemplo // Error!
    // Variables Primitivas
    val nombreProfesor: String = "Adrian Eguez"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'C'
    val mayorEdad:Boolean = true
    // Clases en Java
    val fechaNacimiento: Date = Date()




    // When (Switch)
    val estadoCivilWhen = "C"
    when (estadoCivilWhen){
        ("C") ->{
            println("Casado")
        }
        "S" -> {
            println("Soltero")
        }
        else ->{
            println("No sabemos")
        }
    }
    val esSoltero = (estadoCivilWhen == "S")
    val coqueteo = if (esSoltero) "Si" else "No" // if else chiquito


    imprimirNombre("ADRIAN")

    calcularSueldo(10.00) // solo paramtro requerido
    calcularSueldo(10.00,15.00,20.00) // parametro requerido y sobreescribir parametros opcionales
    // Named parameters
    // calcularSueldo(sueldo, tasa, bonoEspecial)
    calcularSueldo(10.00, bonoEspecial = 20.00) // usando el parametro bonoEspecial en 2da posicion
    // gracias a los parametros nombrados
    calcularSueldo(bonoEspecial = 20.00, sueldo=10.00, tasa=14.00)
    // usando el parametro bonoEspecial en 1ra posicion
    // usando el parametro sueldo en 2da posicion
    // usando el parametro tasa en 3era posicion
    // gracias a los parametros nombrados

    val SumaA = Suma(1,2)
    val SumaB = Suma(null,1)
    val SumaC = Suma(1,null)
    val SumaD = Suma(null,null)

    SumaA.sumar()
    SumaB.sumar()
    SumaC.sumar()
    SumaD.sumar()
    println(Suma.historialSumas)
    println(Suma.pi)
    println(Suma.elevarAlCuadrado(2))

    val arregloEstatico: Array<Int> = arrayOf<Int>(1,2,3)
    println(arregloEstatico)
    val arregloDinamico: ArrayList<Int> = arrayListOf<Int>(1, 2, 3)

    println(arregloDinamico)
    arregloDinamico.add(4)
    println(arregloDinamico)
    arregloDinamico.remove(2)

    //For each = > Unit
    // Iterar un arreglo
    val respuestaForEach: Unit = arregloDinamico.forEach{
        valorIteracion:Int -> println("Valor iteracion: ${valorIteracion}")
    }
    //it (en ingles) eso significa el elemeto iterado
    arregloDinamico.forEach{
        println("Valor iteracion: ${it} ")
    }
    //MAP -> MUTA modifica cambia el arreglo
    // 1) enviamos el nuevo valor de la iteracion
    // 2) Nos devuelve el NUEVO arreglo con los valores modificados
    val respuestaMap: List<Double> = arregloDinamico.map{
        valorActual:Int -> return@map valorActual.toDouble() + 100.00
    }
    println(respuestaMap)
    val respuestaMapDos = arregloDinamico.map{it + 15}
    println(respuestaMapDos)

    //Filter -> Filtrar el arreglo
    // 1) devolver una expresion (TRUE o FALSE)
    // 2) Nuevo arreglo con los valores filtrados
    val respuestaFilter: List<Int> = arregloDinamico.filter{
        valorActualFiltro:Int -> val mayoresACinco:Boolean = valorActualFiltro > 5
        return@filter mayoresACinco
    }
    val resultadoFilterDos = arregloDinamico.filter{it <= 5}
    println(respuestaFilter)
    println(resultadoFilterDos)

    // OR AND
    // AND -> todas las condiciones deben cumplirse para que el resultado sea TRUE
    // OR -> minimo una condicion se debe cumplir para que el resultado sea TRUE
    val respuestaAny: Boolean = arregloDinamico.any{
        valorActualAny:Int -> return@any valorActualAny > 12
    }
    println(respuestaAny)
    val respuestaAll: Boolean = arregloDinamico.all{
        valorActualAll:Int -> return@all valorActualAll > 12
    }
    println(respuestaAll)

    //REDUCE -> Valor acumulado
    // 1) Devuelve el acumulado
    // 2) En que valor empieza
    val respuestaReduce = arregloDinamico.reduce{
        acumulado:Int, valorActualReduce:Int -> return@reduce acumulado + valorActualReduce
    }
    println(respuestaReduce)

}

fun imprimirNombre(nombre:String): Unit{
    fun otraFuncionAdentro(){
        println("Otra funcion adentro")
    }
    println("Nombre: $nombre") // Uso sin llaves
    println("Nombre: ${nombre}") // Uso con llaves opcional
    println("Nombre: ${nombre + nombre}") // Uso con llaves (concatenado)
    println("Nombre: ${nombre.toString()}") // uso con llaves (funcion)
    println("Nombre: $nombre.toString()") // INCORRECTO!
    // (no pueden usar sin llaves)
    otraFuncionAdentro()
}

fun calcularSueldo(
    sueldo:Double, // Requerido
    tasa: Double = 12.00, // Opcional (defecto)
    bonoEspecial:Double? = null // Opcional (nullable)
    // Variable? -> "?" Es Nullable (osea que puede en algun momento ser nulo)
):Double {
    // Int -> Int? (nullable)
    // String -> String? (nullable)
    // Date -> Date? (nullable)
    if(bonoEspecial == null){
        return sueldo * (100/tasa)
    }else{
        return sueldo * (100/tasa) * bonoEspecial
    }
}



abstract class NumerosJava{
    protected val numeroUno:Int
    private val numeroDos: Int
    constructor(
        uno:Int,
        dos:Int
    ){
        this.numeroUno = uno
        this.numeroDos = dos
        println("Inicializando")
    }
}

abstract class Numeros( // Constructor Primario
    // Caso 1) Parametro normal
    // uno:Int , (parametro (sin modificador acceso))

    // Caso 2) Parametro y propiedad (atributo) (protected)
    // private var uno: Int (propiedad "instancia.uno")
    protected val numeroUno: Int, // instancia.numeroUno
    protected val numeroDos: Int, // instancia.numeroDos
    parametroNoUsadoNoPropiedadDeLaClase:Int? = null
){
    init { // bloque constructor primario OPCIONAL
        this.numeroUno
        this.numeroDos
        println("Inicializando")
    }
}

class Suma( // Constructor primario
    unoParametro: Int, // Parametro
    dosParametro: Int, // Parametros
): Numeros( // Clase papa, Numeros (extendiendo)
    unoParametro,
    dosParametro
){
    public val soyPublicoExplicito: String = "Publicas"
    val soyPublicoImplicite: String = "Publico implicito"
    init { // bloque constructor primario
        this.numeroUno
        this.numeroDos
        numeroUno // this. OPCIONAL  [propiedades, metodos]
        numeroDos // this. OPCIONAL  [propiedades, metodos]
        this.soyPublicoImplicite
        soyPublicoExplicito
    }
    constructor( // Constructor secundario
        uno: Int?, // Entero nullable
        dos: Int,
    ):this(
        if(uno == null) 0 else uno,
        dos
    ){
        // Bloque de codigo de constructor secundario
    }
    constructor( // Constructor secundario
        uno: Int,
        dos: Int?,// Entero nullable
    ):this(
        uno,
        if(dos == null) 0 else dos
    )

    constructor( // Constructor secundario
        uno: Int?, // Entero nullable
        dos: Int?,
    ):this(
        if(uno == null) 0 else uno,
        if(dos == null) 0 else dos
    )
    fun sumar():Int{
        // this.numeroUno
        // this.numeroDos
        agregarHistorial(this.numeroUno + this.numeroDos)
        return this.numeroUno + this.numeroDos
    }
    companion object{ // comparte entre todas las instancias, similar a static
        //funciones y variables
        // nombreclase.metodo, nombreClase.funcion ==>
        ///Suma.pi
        val pi = 3.14
        //Suma.elevarAlCuadrado
        fun elevarAlCuadrado(numero:Int):Int{
            return numero * numero
        }
        val historialSumas = arrayListOf<Int>()
        fun agregarHistorial(nuevaSuma:Int){
            this.historialSumas.add(nuevaSuma)
        }

    }

}