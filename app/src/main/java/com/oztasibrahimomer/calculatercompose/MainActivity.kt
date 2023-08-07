package com.oztasibrahimomer.calculatercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oztasibrahimomer.calculatercompose.ui.theme.CalculaterComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MainScreen()

        }
    }
}

@Composable

fun MainScreen(){
    var resultString= remember { mutableStateOf("Result:") }

    Surface(color = Color.Cyan, modifier = Modifier.fillMaxSize()) {


        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Basic Calculater", fontSize = 30.sp, fontStyle = FontStyle.Italic,textAlign=TextAlign.Center,
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .width(300.dp)
                    .height(65.dp))
            val number1=1
            var myString=remember{ mutableStateOf("") }
            var myString2=remember{ mutableStateOf("") }


            Spacer(modifier = Modifier.padding(bottom = 50.dp))

            SpecialTextField(number1,string = myString.value){

                myString.value=it.toString()
            }

            Spacer(modifier = Modifier.padding(bottom = 15.dp))

            val number2=2

            SpecialTextField(number2,myString2.value){

                myString2.value=it.toString()


            }



            Row(horizontalArrangement = Arrangement.SpaceEvenly) {

                val stringList= arrayOf("+","-","x","/")

                Button(onClick = {
                    if(myString.value.isEmpty()||myString2.value.isEmpty()){

                        resultString.value="Gecersiz islem"


                    }
                    else{

                        var result=myString.value.toInt()+myString2.value.toInt()

                        resultString.value="Result: $result"

                    }

                }) {
                    Text(text = stringList[0], color = Color.White, fontSize = 18.sp)

                }
                Spacer(modifier = Modifier.padding(5.dp))
                Button(onClick = {
                    if(myString.value.isEmpty()||myString2.value.isEmpty()){

                        resultString.value="Gecersiz islem"


                    }
                    else{



                        var result=myString.value.toInt()-myString2.value.toInt()

                        resultString.value="Result: $result"

                    }

                }) {
                    Text(text = stringList[1], color = Color.White, fontSize = 18.sp)

                }
                Spacer(modifier = Modifier.padding(5.dp))
                Button(onClick = {
                    if(myString.value.isEmpty()||myString2.value.isEmpty()){

                        resultString.value="Gecersiz islem"


                    }
                    else{

                        var result=myString.value.toInt()*myString2.value.toInt()

                        resultString.value="Result: $result"

                    }

                }) {
                    Text(text = stringList[2], color = Color.White, fontSize = 18.sp)

                }
                Spacer(modifier = Modifier.padding(5.dp))
                Button(onClick = {
                    if(myString.value.isEmpty()||myString2.value.isEmpty()){

                        resultString.value="Gecersiz islem"


                    }
                    else{

                        var result=myString.value.toDouble()/myString2.value.toDouble()

                        resultString.value="Result: $result"

                    }

                }) {
                    Text(text = stringList[3], color = Color.White, fontSize = 18.sp)

                }


            }

            Spacer(modifier = Modifier.padding(bottom=25.dp))



            Text(text = resultString.value, fontSize = 25.sp,color=Color.Black, modifier = Modifier
                .background(Color.White)
                .width(300.dp)
                .height(60.dp))

        }




        
    }
}



@Composable
fun SpecialTextField(number:Int,string:String,function:(String) ->Unit){

    TextField(value =string , onValueChange =function , placeholder = {

        Text(text = "Enter number $number : ", fontSize = 25.sp, color = Color.Black)
    })
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()

}

