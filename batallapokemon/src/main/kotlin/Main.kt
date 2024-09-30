/*BATALLA POKEMON*/
/*La lucha entre dos pokemons*/
/*1.- Definir los tipos de ataques de cada Pokemon*/
/*2.- El usuario tenga un Pokemon fijo*/
/*3.- El usuario pueda elegir el ataque, mientras que la maquina lo hace de forma aleatoria*/

/*TIPOS CREADOS*/
enum class TipoPokemon {AGUA,ELECTRICO,FUEGO}
enum class TipoAtaque {NORMAL, ELECTRICO, PSIQUICO, AGUA, LUCHA}

class Ataque(val nombre:String, val tipoAtaque: TipoAtaque,val valor:Int)

/*CLASE POKEMON*/
class Pokemon(val nombre:String,val tipo:TipoPokemon,var vida:Int=0,val ataques:Array<Ataque>){
    //Funciones para el juego

    fun quitarVida(danyo:Int =0){
        this.vida = this.vida - danyo
    }

    fun imprimirAtaques(){
        var i=0
        for(ataque in ataques){
            print("${ataque.nombre}[$i] ")
            i++
        }
        println()
    }
}

fun main(args: Array<String>) {

    /*DEFINIMOS VARIABLES*/
    var jugarPartida=true
    var ataqueElegido:String=""
    var turnoPikachu:Boolean=true
    var ataqueSquirle:Int=0

    /*DEFINIMOS ATAQUES DE POKEMON*/
    val ataquesPikachu=arrayOf(
        Ataque("Látigo",TipoAtaque.NORMAL,30),
        Ataque("BolaVoltio",TipoAtaque.ELECTRICO,10),
        Ataque("Agilidad",TipoAtaque.PSIQUICO,30)
    )
    val ataquesSquirtle=arrayOf(
        Ataque("Sorpresa",TipoAtaque.NORMAL,40),
        Ataque("Demolicion",TipoAtaque.LUCHA,10),
        Ataque("Buceo",TipoAtaque.AGUA,20)
    )
    /*DEFINIMOS POKEMOS*/
    val pikachu=Pokemon("Pikachu",TipoPokemon.ELECTRICO,100,ataquesPikachu)
    val squirtle=Pokemon("Squirtle",TipoPokemon.AGUA,100,ataquesSquirtle)

    println(" ---- COMENZAMOS LA PARTIDA ----")
    println(" ${pikachu.nombre.uppercase()} : ${pikachu.vida} ")
    println(" ${squirtle.nombre.uppercase()} : ${squirtle.vida} ")

    /*JUEGO*/
    while(jugarPartida){
        if(turnoPikachu){
            println("-- ATACA PIKACHU --")
            pikachu.imprimirAtaques()
            //Recogemos el ataque a usar
            ataqueElegido = readln()
            when (ataqueElegido.toInt()) {
                0 -> squirtle.quitarVida(pikachu.ataques[0].valor)
                1 -> squirtle.quitarVida(pikachu.ataques[1].valor)
                2 -> squirtle.quitarVida(pikachu.ataques[2].valor)
                else -> squirtle.quitarVida(0)
            }
            turnoPikachu = false
        }else{
                /*
        * if(ataqueElegido.toInt() in 0..2) squirtle.quitarVida(pikachu.ataques[ataqueElegido.toInt()].valor)
        * else squirtle.quitarVida(0)
        * */
            println("-- ATACA SQUIRTLE --")
            squirtle.imprimirAtaques()
            ataqueSquirle = (0..2).random()
            when (ataqueSquirle.toInt()) {
                0 -> pikachu.quitarVida(squirtle.ataques[0].valor)
                1 -> pikachu.quitarVida(squirtle.ataques[1].valor)
                2 -> pikachu.quitarVida(squirtle.ataques[2].valor)
                else -> pikachu.quitarVida(0)
            }
            turnoPikachu = true
            //Se dar la condifcion de fin de partida
        }
        println(" ${pikachu.nombre.uppercase()} : ${pikachu.vida} ")
        println(" ${squirtle.nombre.uppercase()} : ${squirtle.vida} ")
        if(squirtle.vida<=0 || pikachu.vida<=0) jugarPartida = false
    }

    /*FIN PARTIDA*/
    println("---- FIN PARTIDA ----")

}