package com.example.unittestpractice

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class CalculatorTest {

    @Test
    fun `1 + 1 is equal to 2`() {
        val result = Calculator.sum(1.0, 1.0)
        assertThat(result).isEqualTo(2.0)
    }

    @Test
    fun `a + 0 is equal to a`() {
        val result = Calculator.sum(1.0, 0.0)
        assertThat(result).isEqualTo(1.0)
    }

    @Test
    fun `-1,5 + -1,5 is equal to -3`() {
        val result = Calculator.sum(-1.5, -1.5)
        assertThat(result).isEqualTo(-3.0)
    }

    @Test
    fun `1 - 1 is equal to 0`() {
        val result = Calculator.subtract(1.0, 1.0)
        assertThat(result).isEqualTo(0.0)
    }

    @Test
    fun `a - 0 is equal to a`() {
        val result = Calculator.subtract(1.0, 0.0)
        assertThat(result).isEqualTo(1.0)
    }

    @Test
    fun `1 - 2 is not equal to 1`() {
        val result = Calculator.subtract(1.0, 2.0)
        assertThat(result).isNotEqualTo(1.0)
    }

    @Test
    fun `a * 0 is equal to 0`() {
        val result = Calculator.multiply(1.0, 0.0)
        assertThat(result).isEqualTo(0.0)
    }

    @Test
    fun `+ * - is equal to -`() {
        val result = Calculator.multiply(1.0, -1.0)
        assertThat(result).isLessThan(0.0)
    }

    @Test
    fun `- * - is equal to +`() {
        val result = Calculator.multiply(-1.0, -1.0)
        assertThat(result).isGreaterThan(0.0)
    }

    @Test
    fun `+ * + is equal to +`() {
        val result = Calculator.multiply(1.0, 1.0)
        assertThat(result).isGreaterThan(0.0)
    }

    @Test
    fun `20 * 10 is equal to 200`() {
        val result = Calculator.multiply(20.0, 10.0)
        assertThat(result).isEqualTo(200.0)
    }

    @Test
    fun `a divided by 0 gives error`() {
        val result = Calculator.divide(1.0, 0.0)
        assertThat(result).isNull()
    }

    @Test
    fun `+ divided by - is equal to -`() {
        val result = Calculator.divide(1.0, -1.0)
        assertThat(result).isLessThan(0.0)
    }

    @Test
    fun `- divided by - is equal to +`() {
        val result = Calculator.divide(-1.0, -1.0)
        assertThat(result).isGreaterThan(0.0)
    }

    @Test
    fun `+ divided by + is equal to +`() {
        val result = Calculator.divide(1.0, 1.0)
        assertThat(result).isGreaterThan(0.0)
    }

    @Test
    fun `20 divided by 10 is equal to 2`() {
        val result = Calculator.divide(20.0, 10.0)
        assertThat(result).isEqualTo(2.0)
    }
}