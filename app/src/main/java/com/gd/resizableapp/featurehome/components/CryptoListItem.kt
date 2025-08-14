package com.gd.resizableapp.featurehome.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.gd.resizableapp.model.Crypto

/**
 * Displays a single cryptocurrency item in a list.
 *
 * Shows the crypto's image, name, and price inside a clickable [Card].
 * This composable is typically used inside a vertical list of cryptocurrencies.
 *
 * @param crypto The [Crypto] object containing data to display (name, image, price).
 * @param onClick Lambda invoked when the user taps on this list item.
 */
@Composable
fun CryptoListItem(crypto: Crypto, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = crypto.imageUrl,
                    contentDescription = "${crypto.name} logo",
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(16.dp))
                Text(text = crypto.name, style = MaterialTheme.typography.bodyLarge)
            }
            Text(text = "€${crypto.price}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
