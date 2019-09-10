const val startMenu = """
    :: Bienvenido a Recipe Maker ::
    
    
    Selecciona la opcion deseada
    1. Hacer una receta
    2. Ver mis recetas
    3. Salir
"""

val ingredientsList = listOf(
    "Agua", "Leche", "Carne", "Verduras",
    "Frutas", "Cereal", "Huevos", "Aceite", "== GUARDAR ==", "== ATRAS =="
)

const val invalidOption = "Invalid option."

fun main() {
    val savedRecipes = mutableListOf<List<String>>()
    mainProgram@ do {
        println(startMenu)
        when (readLine()) {
            "1" -> savedRecipes.add(createNewRecipe())
            "2" -> showRecipes(savedRecipes)
            "3" -> break@mainProgram
            else -> println(invalidOption)
        }
    } while (true)
}

fun showRecipes(savedRecipes: List<List<String>>) {
    savedRecipes.forEachIndexed { index, list ->
        println("${index + 1}. ${list[list.lastIndex]}")
    }

    val readOption = readLine()?.toInt() ?: -1
    if (readOption == -1 || readOption > savedRecipes.size)
        println("Invalid option.")
    else
        savedRecipes[readOption - 1].forEachIndexed { index, ingredient ->
            if (index < savedRecipes[readOption - 1].size - 1)
                println(ingredient)
        }
}

fun createNewRecipe(): List<String> {
    val listResult = emptyList<String>().toMutableList()


    ingredientsLoop@ do {
        ingredientsList.forEachIndexed { index, ingredient ->
            println("${index + 1}. $ingredient")
        }

        when (readLine()) {
            "1" -> listResult.add(ingredientsList[0])
            "2" -> listResult.add(ingredientsList[1])
            "3" -> listResult.add(ingredientsList[2])
            "4" -> listResult.add(ingredientsList[3])
            "5" -> listResult.add(ingredientsList[4])
            "6" -> listResult.add(ingredientsList[5])
            "7" -> listResult.add(ingredientsList[6])
            "8" -> listResult.add(ingredientsList[7])
            "9" -> {
                println(" Ingrese nombre de la receta: ")
                val listName = readLine() ?: "Default Recipe Name"
                listResult.add(listName)
                break@ingredientsLoop
            }
            "10" -> break@ingredientsLoop
            else -> println("Invalid option.")
        }

    } while (true)

    return listResult.filterNotNull().distinct()
}
