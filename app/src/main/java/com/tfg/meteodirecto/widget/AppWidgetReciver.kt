package com.tfg.meteodirecto.widget

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class AppWidgetReciver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget=AppWidget()

}