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
        <NuxtLink class="ml-3" to="/SignUp"
          ><b-button pill variant="outline-success" class="px-5" size="lg"
            >Log In</b-button
          ></NuxtLink
        >
        <NuxtLink class="ml-3" to="/SignUp"
          ><b-button pill variant="outline-info" class="px-5" size="lg"
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
}
</script>

<style>
</style>