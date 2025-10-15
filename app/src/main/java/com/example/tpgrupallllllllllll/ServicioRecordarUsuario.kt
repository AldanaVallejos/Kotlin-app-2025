package com.example.tpgrupallllllllllll

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.graphics.Color
import android.content.Context

class ServicioRecordarUsuario : Service() {

    private val CHANNEL_ID = "canal_recordar_usuario"
    private val descripcion = "Notificación al recordar usuario"
    private val notificationId = 1234

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        sendNotification()
    }

    // CREAR CANAL DE NOTIFICACIÓN
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                CHANNEL_ID,
                descripcion,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                enableLights(true)  // Permite la emisión de luz
                lightColor = Color.BLUE // Color de la luz
                enableVibration(true) // Permite vibración
            }

            // CREAR INSTANCIA DE NOTIFICACIÓN
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }


    // MOSTRAR NOTIFICACIÓN
    private fun sendNotification() {
        val intent = Intent(this, LoginActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent, PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.icon_notification)
            .setContentTitle("¡Haz recordado el usuario!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, builder.build())
        }
    }

    //ELIMINAR NOTIFICACIÓN
    private fun eliminarNotificacion() {
        with(NotificationManagerCompat.from(this)) {
            cancel(notificationId)
        }
    }


    // MÉTOODO QUE CONTROLA LA LÓGICA DEL QUÉ HACER CON EL SERVICIO (MOSTRAR O ELIMINAR)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val activar = intent?.getBooleanExtra("activar", false) ?: false
        if (activar) {
            sendNotification()
        } else {
            eliminarNotificacion()
            stopSelf() // Detiene el servicio
        }
        return START_NOT_STICKY // Mata el servicio
    }


    override fun onBind(intent: Intent?): IBinder? = null
}
