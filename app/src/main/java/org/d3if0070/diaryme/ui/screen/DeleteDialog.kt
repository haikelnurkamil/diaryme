package org.d3if0070.diaryme.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DeleteDialog(
    onDismissRequest: () -> Unit,
    onDelete: () -> Unit
){
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Apakah kamu yakin ingin menghapus ini?")
                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = { onDismissRequest() }
                    ) {
                        Text(text = "Tidak")
                    }
                    Button(
                        onClick = { onDelete() },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text(text = "Iya")
                    }
                }
            }
        }
    }
}