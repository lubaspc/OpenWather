package com.lubaspc.testopenweather.ui.presenter

import com.lubaspc.domain.model.Test

class DialogWeatherPresenter {
    fun formatTest(test: Test) =
        "<b>Fecha de consulta:</b> ${test.createdAt.toLocaleString()} <br>" +
                "<p>" +
                "<b>Nombre:</b> ${test.name} <br>" +
                "<b>Código del país:</b> ${test.sys.country} <br>" +
                "<b>Zona horaria:</b> ${test.timezone} sec. <br>" +
                "</p>" +
                "<p>" +
                "<b>Clima:</b> ${test.weather[0].main} <br>" +
                "<b>Descripción  del clima:</b> ${test.weather[0].description} <br>" +
                "<b>Porcentaje  de nueves:</b> ${test.clouds.all}% <br>" +
                "<b>Humedad:</b> ${test.main.humidity}% <br>" +
                "</p>" +
                "<p>" +
                "<b>Velocidad del viento:</b> ${test.wind.speed}m/s <br>" +
                "<b>Dirección  del viento:</b> ${test.wind.deg}° <br>" +
                "</p>" +
                "<p>" +
                "<b>Temperatura:</b> ${getCelsius(test.main.temp)}°c <br>" +
                "<b>Temperatura mínima:</b> ${getCelsius(test.main.temp_min)}°c <br>" +
                "<b>Temperatura máxima:</b> ${getCelsius(test.main.temp_max)}°c <br>" +
                "<b>Sensación termina:</b> ${getCelsius(test.main.feels_like)}°c <br>" +
                "</p>" +
                "<p>" +
                "<b>Sensación atmosférica:</b> ${test.main.pressure} <br>" +
                "</p>"

    private fun getCelsius(kelvin: Double) =
        Math.round(kelvin - 273.15)
}