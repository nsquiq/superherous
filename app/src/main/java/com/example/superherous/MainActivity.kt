

package com.example.superherous

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superherous.data.heros
import com.example.superherous.data.Hero
import com.example.superherous.ui.theme.SuperherousTheme
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superherous.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperherousTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                    SuperApp()
                }
            }
        }
    }
}

@Composable
fun SuperApp(){
    LazyColumn{
        items(heros){
            HeroItem(hero = it)
        }
    }
}
@Composable
fun HeroItem(
    hero:Hero,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .fillMaxWidth()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {

            HeroInformation(hero.name, hero.description)
            Spacer(Modifier.width(16.dp))
           HeroIcon(hero.imageResourceId)
        }
    }
}
@Composable
fun HeroIcon(
    @DrawableRes heroIcon: Int,
    modifier: Modifier = Modifier
) {

        Image(
            modifier = modifier
                .size(dimensionResource(R.dimen.image_size))
                .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(heroIcon),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth
        )

}
@Composable
fun HeroInformation(
    @StringRes heroName: Int,
    @StringRes heroDes:  Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier){
        Text(
            text = stringResource(heroName),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(heroDes),
            modifier = modifier
                .width(300.dp)
        )
    }
}
@Preview
@Composable
fun SuperherousPreview(){
    SuperherousTheme(darkTheme = false) {
        SuperApp()


    }
}
@Preview
@Composable
fun SuperherousDarkThemePreview() {
    SuperherousTheme(darkTheme = true) {
        SuperApp()
    }
}
