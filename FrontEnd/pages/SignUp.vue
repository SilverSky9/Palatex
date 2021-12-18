<template>
  <b-container>
    <b-row class="text-center d-flex justify-content-center" align-v="center">
      <b-col cols="5" class="">
        <fa :icon="['fa', 'eraser']" size="8x" />
        <h1 class="font-weight-bold">PALATEX</h1>
        <b-input-group prepend="First Name" class="my-3">
          <b-form-input v-model="Fname" placeholder="name"></b-form-input>
        </b-input-group>
        <b-input-group prepend="Last Name" class="my-3">
          <b-form-input v-model="Lname" placeholder="surname"></b-form-input>
        </b-input-group>
        <b-input-group prepend="Username" class="my-3">
          <b-form-input v-model="user" placeholder="username"></b-form-input>
        </b-input-group>
        <b-input-group prepend="Password" class="my-3">
          <b-form-input v-model="pass" placeholder="password"></b-form-input>
        </b-input-group>
        <b-input-group prepend="Confirm Password" class="my-3">
          <b-form-input
            v-model="Cpass"
            placeholder="confirm password"
          ></b-form-input>
        </b-input-group>
        <b-input-group prepend="Phone Number" class="my-3">
          <b-form-input v-model="phone" placeholder="phone"></b-form-input>
        </b-input-group>
        <NuxtLink class="ml-3" to="/Login"
          ><b-button
            pill
            variant="outline-success"
            class="px-5"
            size="lg"
            @click="postSignUp()"
            >Sign Up</b-button
          ></NuxtLink
        >
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  layout: 'Navbar',
  methods: {
    async postSignUp() {
      var user_count
      await this.$axios
        .$get('http://localhost:8093/user/count')
        .then((res) => (user_count = res))

      var data = {
        user_id: user_count,
        firstname: this.Fname,
        lastname: this.Lname,
        phone_number: this.phone,
        username: this.user,
        password: this.pass,
      }

      await this.$axios
        .$post('http://localhost:8093/user/add', data)
        .then((res) => console.log(res))
    },
  },
  data: () => ({
    Fname: '',
    Lname: '',
    user: '',
    pass: '',
    Cpass: '',
    phone: '',
  }),
}
</script>

<style>
</style>