package com.example.pohonapel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TanamPohonApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TanamPohonApp() {
    var currentStep by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Tanam Pohon Apel",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    PohonTextAndImage(
                        textLabel = "Tanah kosong siap ditanam",
                        drawableResourceId = R.drawable.tanah,
                        onImageClick = { currentStep = 2 }
                    )
                }
                2 -> {
                    PohonTextAndImage(
                        textLabel = "Menanam bibit pohon",
                        drawableResourceId = R.drawable.nanem_bibit,
                        onImageClick = { currentStep = 3 }
                    )
                }
                3 -> {
                    // Menyiram Step 1
                    PohonTextAndImage(
                        textLabel = "Menyiram tanaman",
                        drawableResourceId = R.drawable.nyiram1,
                        onImageClick = { currentStep = 4 }
                    )
                }
                4 -> {
                    // Menyiram Step 2
                    PohonTextAndImage(
                        textLabel = "Menyiram tanaman",
                        drawableResourceId = R.drawable.nyiram2,
                        onImageClick = { currentStep = 5 }
                    )
                }
                5 -> {
                    // Menyiram Step 3
                    PohonTextAndImage(
                        textLabel = "Menyiram tanaman",
                        drawableResourceId = R.drawable.nyiram3,
                        onImageClick = { currentStep = 6 }
                    )
                }
                6 -> {
                    PohonTextAndImage(
                        textLabel = "Memberi pupuk",
                        drawableResourceId = R.drawable.memupuk,
                        onImageClick = { currentStep = 7 }
                    )
                }
                7 -> {
                    PohonTextAndImage(
                        textLabel = "Pohon mulai tumbuh besar",
                        drawableResourceId = R.drawable.pohon_tumbuh,
                        onImageClick = { currentStep = 8 }
                    )
                }
                8 -> {
                    PohonTextAndImage(
                        textLabel = "Pohon mulai berbuah",
                        drawableResourceId = R.drawable.awal_berbuah,
                        onImageClick = { currentStep = 9 }
                    )
                }
                9 -> {
                    PohonTextAndImage(
                        textLabel = "Buah apel sudah matang lebat!",
                        drawableResourceId = R.drawable.apel,
                        onImageClick = { currentStep = 10 }
                    )
                }
                10 -> {
                    PohonTextAndImage(
                        textLabel = "Panen buah apel!",
                        drawableResourceId = R.drawable.panen_apel,
                        onImageClick = { currentStep = 1 }
                    )
                }
            }
        }
    }
}

@Composable
fun PohonTextAndImage(
    textLabel: String,
    drawableResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = textLabel,
                    modifier = Modifier
                        .width(160.dp)
                        .height(160.dp)
                        .padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = textLabel,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TanamPohonPreview() {
    MaterialTheme {
        TanamPohonApp()
    }
}
