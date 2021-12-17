<script>
import { Bar } from 'vue-chartjs'

export default {
  extends: Bar,
  props: ['chartData', 'options'],
  methods: {
    update() {
      this.$data._chart.update()
    },
  },
  mounted() {
    this.renderChart(this.chartData, this.options)
    setTimeout(() => {
      this.renderChart(this.chartData, this.options)
    }, 1000)
  },
}
</script>