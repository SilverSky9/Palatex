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
        <a class="ml-3"
          ><b-button
            pill
            variant="outline-success"
            class="px-5"
            size="lg"
            @click="postSignUp()"
            >Sign Up</b-button
          ></a
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
      var data = {
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
    Fname: 'pawaris',
    Lname: 'wongsaied',
    user: 'farrock@outlook.co.th',
    pass: 'heart555',
    Cpass: 'heart555',
    phone: '0957862118',
  }),
}
</script>

<style>
</style>