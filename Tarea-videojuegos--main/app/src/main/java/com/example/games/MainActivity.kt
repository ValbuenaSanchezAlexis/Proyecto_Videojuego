package com.example.games
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.games.ui.theme.AppVideojuegosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val juegos = listOf(
            Game(1, "Elden Ring", "PS5"),
            Game(2, "Zelda BOTW", "Switch"),
            Game(3, "Cyberpunk", "PC"),
            Game(4, "Hades", "Switch"),
            Game(5, "God of War", "PS5"),
            Game(6, "Red Dead 2", "Xbox"),
            Game(7, "Minecraft", "PC"),
            Game(8, "Stardew", "Switch"),
            Game(9, "FF VII", "PS5"),
            Game(10, "Baldur's Gate", "PC")
        )
        setContent {
            AppVideojuegosTheme {
                // Vamos a forzar un Surface (fondo) con el color que queremos
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background // Esto debe ser AmarilloSuave
                ) {
                    CatalogoScreen(juegos)
                }
            }
        }
    }
}

@Composable
fun CatalogoScreen(juegos: List<Game>) {
    LazyColumn(Modifier.padding(16.dp)) {
        item { Text("Destacados (Grid)", style = MaterialTheme.typography.headlineSmall) }

        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.height(200.dp),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(juegos.take(4)) { CardJuego(it) }
            }
        }

        item { Text("Catálogo Completo (Column)", style = MaterialTheme.typography.headlineSmall) }

        items(juegos.drop(4)) { CardJuego(it) }
    }
}

@Composable
fun CardJuego(juego: Game) {
    Card(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(juego.titulo, style = MaterialTheme.typography.titleMedium)
            Text(juego.plataforma, style = MaterialTheme.typography.bodySmall)
        }
    }
}