package com.gd.resizableapp.featuredetail

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil3.compose.AsyncImage
import com.gd.resizableapp.model.Crypto

/**
 * Displays the detail pane for a selected cryptocurrency within a list-detail layout.
 *
 * If a [crypto] is provided, it shows the [DetailScreen] for that cryptocurrency.
 * If no [crypto] is selected, it shows a placeholder message prompting the user
 * to select an item from the list.
 *
 * This composable is typically used in combination with a [androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold].
 *
 * @param modifier A [Modifier] for styling and layout adjustments.
 * @param crypto The currently selected [Crypto] to display, or null if none is selected.
 * @param onBack Lambda to handle back navigation from the detail screen.
 */
@Composable
fun SupportingPane(
    modifier: Modifier = Modifier,
    crypto: Crypto?,
    onBack: () -> Unit
) {
    Scaffold(
        contentColor = MaterialTheme.colorScheme.onPrimary,
        containerColor = MaterialTheme.colorScheme.primary
    ) { innerPadding ->
        if (crypto != null) {
            DetailScreen(
                modifier = modifier.padding(innerPadding),
                crypto = crypto,
                onBack = onBack
            )
        } else {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Select a cryptocurrency from the list")
            }
        }
    }
}

/**
 * Displays detailed information about a single cryptocurrency.
 *
 * Shows the crypto's name, image, price, description, and provides a button
 * to open its official website. Includes a back button for navigation.
 *
 * @param modifier A [Modifier] for styling and layout adjustments.
 * @param crypto The [Crypto] object whose details are displayed.
 * @param onBack Lambda invoked when the back button is clicked.
 */
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    crypto: Crypto,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    Column(modifier = modifier.padding(16.dp)) {
        IconButton(onClick = onBack) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                model = crypto.imageUrl,
                contentDescription = crypto.description
            )
            Spacer(Modifier.width(16.dp))
            Text(text = crypto.name, style = MaterialTheme.typography.headlineLarge)
        }
        Text(text = "Price: €${crypto.price}", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(16.dp))
        Text(text = crypto.description, style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(16.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, crypto.websiteLink.toUri())
                context.startActivity(intent)
            },
            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 5.dp)
        ) {
            Text(
                text = "Go to Website",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}
