package com.gd.resizableapp.featurehome

import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.gd.resizableapp.model.Crypto
import com.gd.resizableapp.R
import com.gd.resizableapp.core.utils.getMockCryptos
import com.gd.resizableapp.featuredetail.SupportingPane
import com.gd.resizableapp.featurehome.components.CryptoListItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun ListScaffold(modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    val navigator = rememberListDetailPaneScaffoldNavigator<Crypto?>()

    BackHandler(navigator.canNavigateBack()) {
        scope.launch { navigator.navigateBack() }
    }

    ListDetailPaneScaffold(
        modifier = modifier,
        directive = navigator.scaffoldDirective,
        scaffoldState = navigator.scaffoldState,
        listPane = {
            MainPane(
                cryptos = getMockCryptos(),
                onCryptoSelected = {
                    scope.launch {
                        navigator.navigateTo(
                            ListDetailPaneScaffoldRole.Detail,
                            contentKey = it
                        )
                    }
                }
            )
        },
        detailPane = {
            SupportingPane(
                crypto = navigator.currentDestination?.contentKey,
                onBack = { scope.launch { navigator.navigateBack() } }
            )
        }
    )
}

@Composable
fun MainPane(
    cryptos: List<Crypto>,
    onCryptoSelected: (Crypto) -> Unit
) {
    ListScreen(
        modifier = Modifier
            .animateContentSize()
            .safeContentPadding(),
        cryptos = cryptos,
        onCryptoSelected = onCryptoSelected
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    cryptos: List<Crypto>,
    onCryptoSelected: (Crypto) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.home)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        contentColor = MaterialTheme.colorScheme.onPrimary,
        containerColor = MaterialTheme.colorScheme.primary
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            cryptos.forEach { crypto ->
                CryptoListItem(crypto = crypto) { onCryptoSelected(crypto) }
            }
        }
    }
}
