<template>
  <b-container>
    <b-row
      class="mt-5 text-center d-flex justify-content-center"
      align-v="center"
    >
      <b-col cols="5" class="">
        <fa :icon="['fa', 'eraser']" size="10x" />
        <div class="display-1 font-weight-bold">PALATEX</div>
        <b-input-group prepend="Username" class="my-3">
          <b-form-input></b-form-input>
        </b-input-group>
        <b-input-group prepend="Password" class="my-3">
          <b-form-input></b-form-input>
        </b-input-group>
        <b-button
          pill
          variant="outline-success"
          class="px-5"
          size="lg"
          @click="signin()"
          >Login</b-button
        >
        <NuxtLink class="ml-3" to="/SignUp"
          ><b-button pill variant="outline-success" class="px-5" size="lg"
            >Sign up</b-button
          ></NuxtLink
        >
        <b-button
          pill
          variant="outline-success"
          class="px-5"
          size="lg"
          @click="localTest()"
          >Local sotrage</b-button
        >
        <b-button
          pill
          variant="outline-success"
          class="px-5"
          size="lg"
          @click="getLocal()"
          >Get Local sotrage</b-button
        >
        <b-button
          pill
          variant="outline-success"
          class="px-5"
          size="lg"
          @click="testshit()"
          >Get
        </b-button>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  layout: 'Navbar',
  methods: {
    async signin() {
      var data = {
        username: 'Maysa',
        password: '12345',
      }
      await this.$axios
        .$post('http://localhost:8093/authen', data)
        .then((res) => {
          localStorage.setItem('token', res)
          this.$store.commit('set_token', res)
          this.$store.commit('set_header_token', this.$store.state.token)
          console.log(this.$store.state.header_token)
        })
      //.catch((error) => console.log(error.response.status))
    },
    async testshit() {
      var headers = {
        //withCredentials: true,
        headers: {
          Authorization:
            'Bearer ' +
            'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNYXlzYSIsInJvbGUiOiJ1c2VyIiwiZXhwIjoxNjM5NzczNDc3LCJpYXQiOjE2Mzk3Mzc0Nzd9.yzJVmNhENFprmSy2zee_c-sH7NFQmwtowV3JYjqSQHk',
        },
      }

      await this.$axios
        .$get('http://localhost:8093/user/all', headers)
        .then((res) => console.log(res))
      // .catch((error) => console.log(error.response.status))
      //this.$store.commit('set_token', 'sas')
      console.log(this.$store.state.token)
    },
    setLocalStorage(token) {
      if (process.client) {
        localStorage.setItem('token', 'Bearer ' + token)
      }
    },
    getLocal() {
      console.log(localStorage.getItem('authToken'))
    },
  },
}
</script>

<style>
</style>