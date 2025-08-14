package com.gd.resizableapp.core.utils

import com.gd.resizableapp.model.Crypto

fun getMockCryptos(): List<Crypto> {
    return listOf(
        Crypto(
            "btc",
            "Bitcoin",
            60000.00,
            "https://placehold.co/100x100/orange/white?text=BTC",
            "Bitcoin is a decentralized digital currency, without a central bank or single administrator.",
            "https://bitcoin.org"
        ),
        Crypto(
            "eth",
            "Ethereum",
            4000.00,
            "https://placehold.co/100x100/gray/white?text=ETH",
            "Ethereum is a decentralized, open-source blockchain with smart contract functionality.",
            "https://ethereum.org"
        ),
        Crypto(
            "ada",
            "Cardano",
            1.50,
            "https://placehold.co/100x100/blue/white?text=ADA",
            "Cardano is a public blockchain platform. It is open-source and decentralized, with consensus achieved via proof-of-stake.",
            "https://cardano.org"
        ),
        Crypto(
            "doge",
            "Dogecoin",
            0.25,
            "https://placehold.co/100x100/brown/white?text=DOGE",
            "Dogecoin is a cryptocurrency created as a joke in 2013 by software engineers Billy Markus and Jackson Palmer.",
            "https://dogecoin.com"
        ),
        Crypto(
            "sol",
            "Solana",
            150.00,
            "https://placehold.co/100x100/purple/white?text=SOL",
            "Solana is a decentralized blockchain built to enable scalable, user-friendly apps for the world.",
            "https://solana.com"
        ),
        Crypto(
            "xrp",
            "XRP",
            1.00,
            "https://placehold.co/100x100/black/white?text=XRP",
            "XRP is the native cryptocurrency of the XRP Ledger, an open-source, permissionless and decentralized blockchain.",
            "https://xrpl.org"
        ),
        Crypto(
            "dot",
            "Polkadot",
            35.00,
            "https://placehold.co/100x100/pink/white?text=DOT",
            "Polkadot is a network protocol that allows arbitrary data—not just tokens—to be transferred across blockchains.",
            "https://polkadot.network"
        ),
        Crypto(
            "luna",
            "Terra",
            40.00,
            "https://placehold.co/100x100/yellow/white?text=LUNA",
            "Terra is a decentralized, open-source blockchain that hosts a vibrant ecosystem of dApps and developer tools.",
            "https://www.terra.money"
        ),
        Crypto(
            "uni",
            "Uniswap",
            25.00,
            "https://placehold.co/100x100/red/white?text=UNI",
            "Uniswap is a decentralized finance protocol that is used to exchange cryptocurrencies.",
            "https://uniswap.org"
        ),
        Crypto(
            "link",
            "Chainlink",
            20.00,
            "https://placehold.co/100x100/green/white?text=LINK",
            "Chainlink is a decentralized oracle network built on Ethereum that provides real-world data to smart contracts on the blockchain.",
            "https://chain.link"
        ),
    )
}