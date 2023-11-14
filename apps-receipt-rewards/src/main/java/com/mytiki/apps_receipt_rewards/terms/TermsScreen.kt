package com.mytiki.apps_receipt_rewards.terms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.utils.components.Header
import com.mytiki.apps_receipt_rewards.utils.components.MainButton
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute

@Composable
fun TermsScreen(termsViewModel: TermsViewModel, navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxSize(),

            topBar = {
                Column {
                    Spacer(modifier = Modifier.height(60.dp))
                    Header(text = "PROGRAM TERMS") {
                        navController.popBackStack()
                    }
                }
            },
            bottomBar = {
                Column {
                    Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(42.dp))
                    MainButton(
                        text = "I agree", isfFilled = true
                    ) {
                        navController.navigate(RewardsRoute.HomeScreen.name)
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                }
             },
            containerColor = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.padding(it),
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

            }

        }
    }
}


val text ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus lobortis risus ac ultrices faucibus. Nullam vel pulvinar neque. Morbi ultrices maximus est, quis blandit urna vestibulum nec. Morbi et finibus nisi. Vestibulum dignissim rutrum mi sit amet sagittis. Aenean id ligula eget enim feugiat luctus vitae vitae orci. Maecenas aliquam semper nunc vel pellentesque. Ut cursus neque non est mattis consequat. Duis posuere odio et tellus aliquam, et tristique erat pharetra. Mauris sollicitudin lorem ligula. Ut lacinia, neque ac ornare gravida, libero turpis fermentum nibh, eget sodales diam magna sit amet lacus. Aliquam pretium suscipit mi eget luctus. Aliquam ut velit ut magna elementum sollicitudin in et magna. Ut a elementum tellus, eu cursus lacus. Pellentesque neque nisi, semper ac mi vel, fringilla semper nisl. Morbi at vulputate lectus, non ornare nulla." +
        "Vestibulum convallis rutrum tellus sed vulputate. Suspendisse condimentum mauris quis odio aliquet, at posuere augue egestas. Nulla finibus nibh ac placerat pretium. Mauris volutpat urna sit amet vehicula fermentum. Praesent semper est diam, sit amet elementum orci luctus ac. Quisque condimentum ipsum in venenatis rutrum. Donec rutrum nisl id elit porttitor, vel scelerisque quam ultricies. Donec vulputate, mi at tempor hendrerit, risus tortor consequat neque, non laoreet orci ante tempor dolor. Curabitur placerat convallis risus, a facilisis diam mollis in." +
        "Mauris in ex dolor. Nunc eu mollis mi. Integer ut nulla egestas, finibus tellus in, congue sem. Vestibulum sit amet velit cursus, consequat purus id, porttitor ligula. Aliquam pellentesque non augue quis tincidunt. Duis a pulvinar odio, non ultrices metus. Sed eu risus quam. Nam vehicula ligula id aliquet aliquet. Quisque faucibus odio pulvinar tellus tristique, eget tempus tellus accumsan. Nulla vehicula nunc quis dapibus lobortis. Sed urna magna, commodo vitae enim eget, scelerisque hendrerit mi. Pellentesque lobortis lectus vitae convallis facilisis." +
        "Phasellus lobortis purus sit amet sodales efficitur. Mauris sapien lorem, pretium id turpis eu, tristique maximus tellus. Donec porttitor, enim ut scelerisque dapibus, lectus tellus laoreet ante, a ornare dolor nisi sed risus. Vestibulum facilisis mollis urna in suscipit. Pellentesque sit amet lobortis nulla. Fusce semper rhoncus urna a gravida. In congue nec nisi eu hendrerit. Donec sed felis elementum lacus posuere porttitor eget quis dolor. Maecenas eu iaculis dolor. Nam venenatis tempor velit vel finibus. Phasellus purus nunc, condimentum sit amet porttitor nec, rhoncus et ante. Fusce tristique nibh quis sem varius ultricies. Maecenas egestas justo sed enim maximus consectetur." +
        "Phasellus malesuada magna a ex mollis varius. Quisque a vulputate metus. Cras in nibh lorem. Proin in enim efficitur, pellentesque elit sed, dictum turpis. Duis sagittis lectus eu magna imperdiet maximus. Nullam condimentum scelerisque arcu ac auctor. Phasellus malesuada erat quis gravida mollis."